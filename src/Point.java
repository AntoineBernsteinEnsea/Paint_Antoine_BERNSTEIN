public class Point {
    int X,Y;

    //constructors
    public Point(){
        X=0;
        Y=0;
    }

    public Point(int X,int Y){
        this.X=X;
        this.Y=Y;
    }


    //getter and setter
    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    //to string
    @Override
    public String toString() {
        return "("+X+","+Y+")";
    }




}
