public class King extends Piece{
    public boolean moved;

    public King(Colours.Colour colour){
        this.type = PieceTypes.PieceType.king;
        this.colour = colour;
        this.value = 0;
    }

    private King(Colours.Colour colour, boolean moved){
        this.type = PieceTypes.PieceType.pawn;
        this.colour = colour;
        this.value = 0;
        this.moved = moved;
    }

    public boolean Move(Coordinates origin, Coordinates destination){
        this.moved = true;
        return false;
    }

    public Piece Copy(){
        return new King(this.colour, this.moved);
    }

    protected Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }
}
