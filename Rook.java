public class Rook extends Piece{
    public boolean moved;

    public Rook(Colours.Colour colour){
        this.type = PieceTypes.PieceType.pawn;
        this.colour = colour;
        this.value = 5;
    }

    private Rook(Colours.Colour colour, boolean moved){
        this.type = PieceTypes.PieceType.pawn;
        this.colour = colour;
        this.value = 5;
        this.moved = moved;
    }

    public boolean Move(Coordinates origin, Coordinates destination){
        this.moved = true;
        return false;
    }

    public Piece Copy(){
        return new Rook(this.colour, this.moved);
    }

    protected Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }
}
