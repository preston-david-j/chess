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

    public Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }

    public Coordinates[] Valid_Moves(Coordinates origin){
        return new Coordinates[0];
    }
}
