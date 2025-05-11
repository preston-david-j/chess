public class Knight extends Piece{
    public Knight(Colours.Colour colour){
        this.type = PieceTypes.PieceType.knight;
        this.colour = colour;
        this.value = 3;
    }

    public boolean Move(Coordinates origin, Coordinates destination){
        return false;
    }

    public Piece Copy(){
        return new Knight(this.colour);
    }

    protected Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }
}
