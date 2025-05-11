public class Coordinates {
    private int x = -1;
    private int y = -1;

    public Coordinates(int x, int y){
        Set_X(x);
        Set_Y(y);
    }

    public boolean Validate(){
        return this.x == -1 || this.y == -1;
    }

    public boolean Equals(Coordinates otherCoordinates){
        return this.x == otherCoordinates.X() && this.y == otherCoordinates.Y();
    }

    public boolean Set_X(int x){
        if(x >= 0 && x <= 7){this.x = x; return true;}
        return false;
    }

    public boolean Set_Y(int y){
        if(y >= 0 && y <= 7){this.y = y; return true;}
        return false;
    }

    public boolean Set(int x, int y){
        if(x < 0 || x > 7){return false;}
        if(y < 0 || y > 7){return false;}
        this.x = x;
        this.y = y;
        return true;
    }

    public int X(){
        return this.x;
    }

    public int Y(){
        return this.y;
    }

}
