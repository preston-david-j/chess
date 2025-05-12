public class Coordinates {
    private int x = -1;
    private int y = -1;

    public Coordinates(int x, int y){
        Set_X(x);
        Set_Y(y);
    }

    public Coordinates(String xy){
        Set_X(xy.charAt(0) - '0');
        Set_Y(xy.charAt(2) - '0');
    }

    public boolean Validate(){
        return this.x != -1 && this.y != -1;
    }

    public boolean Equals(Coordinates otherCoordinates){
        return this.x == otherCoordinates.X() && this.y == otherCoordinates.Y();
    }

    public boolean Set_X(int x){
        if(x >= 0 && x <= 7){this.x = x; return true;}
        else{this.x = -1;}
        return false;
    }

    public boolean Set_Y(int y){
        if(y >= 0 && y <= 7){this.y = y; return true;}
        else{this.y = -1;}
        return false;
    }

    public boolean Set(int x, int y){
        boolean xValid = Set_X(x);
        boolean yValid = Set_Y(y);
        return xValid && yValid;
    }

    public int X(){
        return this.x;
    }

    public int Y(){
        return this.y;
    }

    public Coordinates Copy(){
        return new Coordinates(this.x, this.y);
    }

    public void Display(){
        System.out.println(this.x + "," + this.y);
    }

}
