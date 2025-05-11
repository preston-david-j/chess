public class Pawn extends Piece{
    private boolean moved = false;

    public Pawn(Colours.Colour colour){
        this.type = PieceTypes.PieceType.pawn;
        this.colour = colour;
        this.value = 1;
    }

    private Pawn(Colours.Colour colour, boolean moved){
        this.type = PieceTypes.PieceType.pawn;
        this.colour = colour;
        this.value = 1;
        this.moved = moved;
    }

    public boolean Move(Coordinates origin, Coordinates destination){

        Board.Move(origin, destination);

        this.moved = true;
        return true;
    }

    public Piece Copy(){
        return new Pawn(this.colour, this.moved);
    }

    protected Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }
}
