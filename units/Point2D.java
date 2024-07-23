package units;
public class Point2D {
    int curX;
    int curY;

    int width;
    int height;

    public Point2D(int x, int y) {
        curX = x;
        curY = y;
        width = 10;
        height = 10;
    }

    public boolean isMove(int x, int y) {
        return x>=0 && x < width && y < height && y>=0;

    }

    public int getX() {return curX;}
    public int getY() {return curX;}

    public void setXY(int x, int y)
    {
        curX = x;
        curY = y;
    }

    public void moveTo(int dx, int dy) {
        if (isMove(dx+curX, dy+curY)) {
            curX += dx;
            curY += dy;
        }
    }

    public String toString() {
        return curX + ":" +curY;
    }

    public float distanceTo(Point2D position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'distanceTo'");
    }


}
