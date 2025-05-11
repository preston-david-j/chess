public abstract class Piece{
    protected PieceTypes.PieceType type;
    protected Colours.Colour colour;
    protected int value;
    public abstract boolean Move(Coordinates origin, Coordinates destination);
    public abstract Piece Copy();
    protected abstract Coordinates[] Attack_Trace();
}