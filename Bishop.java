public class Bishop extends Piece{
    public Bishop(Colours.Colour colour){
        this.type = PieceTypes.PieceType.bishop;
        this.colour = colour;
        this.value = 3;
    }

    public boolean Move(Coordinates origin, Coordinates destination){
        return false;
    }   

    public Piece Copy(){
        return new Bishop(this.colour);
    }

    protected Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }
}
