public class Queen extends Piece{
    public Queen(Colours.Colour colour){
        this.type = PieceTypes.PieceType.queen;
        this.colour = colour;
        this.value = 9;
    }

    public boolean Move(Coordinates origin, Coordinates destination){
        return false;
    }

    public Piece Copy(){
        return new Queen(this.colour);
    }

    protected Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }
}
