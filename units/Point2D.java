package units;

public class Point2D {
    private int curX;
    private int curY;

    private static int width;
    private static int height;

    static {
        width = 10;
        height = 10;
    }

    public Point2D(int x, int y) {
        curX = x;
        curY = y;
    }

    public boolean isMove(int x, int y) {
        return x>=0 && x < width && y < height && y>=0;

    }

    public int getX() {return curX;}
    public int getY() {return curY;}

    public void setXY(int x, int y)
    {
        curX = x;
        curY = y;
    }


    public void increment(int dx, int dy)
    {
        curX += dx;
        curY += dy;
    }

    
    public void moveTo(int dx, int dy) {
        if (isMove(dx+curX, dy+curY)) {
            curX += dx;
            curY += dy;
        }
    }

    public float fastDistance(Point2D target, int dx, int dy)
    {
        float tx = curX+dx - target.getX();
        float ty = curY+dy - target.getY();
        return (tx*tx + ty*ty);
    }

    public boolean equal(Point2D to)
    {
        return curX == to.curX && curY == to.curY;
    }


    public String toString() {
        return curX + ":" +curY;
    }

    // опредление расстояния до другого персонажа
    public float distanceTo(Point2D target)
    {
        float x = curX - target.getX();
        float y = curY - target.getY();
        return (float) Math.sqrt(x*x + y*y);
    }


}
