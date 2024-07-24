package units;

import java.util.ArrayList;

public class Wizard extends Character {
    private static final int COST_HEALED = 10;  // кол-во маны за процедуру лечения
    private static final int MANA_RECOVERY = 5; // кол-во восстанавливаемой маны за ход ожидания
    private static final int MANA_TO_HEAL = 3;  // коэфф. конвертации маны в здоровье

    protected int mana;                     // мана для волшебства
    protected int maxMana;
    private int resurrectMana;              // необходимое кол-во маны для воскрешения
    private Character respawnTarget;       // наша цель на воскрешение


    public Wizard(String name, Point2D pos) {
        super(name, 1, 600, 40, 10, 0, 8, pos);
        this.mana = 100;
        this.maxMana = mana;
        this.resurrectMana = mana / 2;
        this.respawnTarget = null;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<Character> enemies, ArrayList<Character> friends)
    {
        history = "";

        if (health <= 0)
            return;
        mana = Math.min(mana + MANA_RECOVERY, maxMana);

        if (isWaitResurrection(friends))
            return;

        if (getNumOfDead(friends, mana >= resurrectMana) > 3)
        {
            beginResurrection(friends);     // воскрешаем
        } else {
            doHeal(friends);                // лечим
        }
    }

    private void beginResurrection(ArrayList<Character> friends)
    {
//        PersonBase p = friends.stream().filter(n -> n.health == 0).sorted((n1, n2) -> n2.priority - n1.priority).collect(Collectors.toList()).getFirst();
        /*
            Ищем подходящую кандидатуру для воскрешения
         */
        Character p = null;
        int max = -1;
        for (Character person : friends)
        {
            if (person.getHeals() < 0 && mana >= resurrectMana)
            {
                p = person;                 // нашли ожидающего, он у нас в приоритете
                break;
            }
            if (person.getHeals() == 0 && max < person.getPriority())
            {
                p = person;
                max = person.getPriority();
            }
        }

        if (p != null)
        {
            respawnTarget = p;
            if (mana >= resurrectMana)
            {
                doResurrection(p);
            } else {
                respawnTarget.health = -1;      // помечаем как ожидающего воскрешение
                history = String.format(" восстанавливает ману для воскрешения %s", respawnTarget);
            }
        }
    }

    /**
     * Воскрешаем цель или продолжаем копить ману для воскрешения
     *
     * @param friends Список своих
     * @return true - пропускаем ход (копим ману), false - ожидание прервано, ходим дальше
     */
    private boolean isWaitResurrection(ArrayList<Character> friends)
    {
        if (respawnTarget == null || respawnTarget.getHeals() >= 0)
        {
            respawnTarget = null;               // некого воскрешать (или уже воскресили)
            return false;
        }
        if (mana >= resurrectMana)
        {
            doResurrection(respawnTarget);      // воскрешаем
        } else {
            history = String.format(" восстанавливает ману для воскрешения %s", respawnTarget);
        }
        return true;
    }

    //Воскрешение персонажа

    private void doResurrection(Character person)
    {
        if (respawnTarget.getHeals() <= 0)
        {
            person.healed(respawnTarget.getMaxHeals());
            mana -= resurrectMana;
            history = String.format(" воскресил %s", respawnTarget);
        } else {
            history = String.format(" не нашел погибшего для воскрешения!");
        }
        respawnTarget = null;
    }

    // Лечение наиболее хилого персонажа

    private void doHeal(ArrayList<Character> friends)
    {
        int min = Integer.MAX_VALUE;
        Character p = null;
        for (Character friend : friends)
        {
            int hp = friend.getHeals() * 100 / friend.getMaxHeals();
            if (hp > 0 && hp < min) {
                min = hp;
                p = friend;
            }
        }
        if (p != null && min < 100)
        {
            int hp = p.getHeals();
            int needMana = (p.getMaxHeals() - hp) / MANA_TO_HEAL;      // кол-во маны для полного лечения
            int n = Math.min(mana, Math.min(needMana, COST_HEALED));
            mana -= n;
            p.healed(n * MANA_TO_HEAL);
            history = String.format(" вылечил %s на %d пунктов здоровья", p, p.getHeals()-hp);
        } else {
            history = String.format(" пропускает ход.");
        }
    }

    //Подсчет погибших

    private int getNumOfDead(ArrayList<Character> friends, boolean isReservation) {
//        return (int) friends.stream().filter(n -> n.getHealth() <= 0).count();
        int count = 0;
        for (Character friend : friends) {
            if (friend.getHeals() == 0)
                count++;
            else if (friend.getHeals() < 0 && isReservation)
                count++;
        }
        return count;
    }

    // Получение повреждений. Если персонаж умирает, то освобождаем respawnTarget.

    @Override
    public int getDamage(int damage)
    {
        int hp = super.getDamage(damage);
        if (health <= 0)
        {
            if (respawnTarget != null)
            {
                if (respawnTarget.getHeals() < 0)
                    respawnTarget.health = 0;
                respawnTarget = null;
            }
        }
        return hp;
    }

    @Override
    public String toString() {
        return String.format("[Волшебник] " + name + " " + position);
    }

}



