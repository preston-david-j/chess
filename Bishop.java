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

    public Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }

    public Coordinates[] Valid_Moves(Coordinates origin){
        return new Coordinates[0];
    }
}
