public class Move {
    public final Coordinates origin;
    public final Coordinates destination;
    public final Piece pieceMoved;
    public final Piece pieceCaptured;
    public final boolean enPassant;

    public Move(Coordinates origin, Coordinates destination, Piece pieceMoved, Piece pieceCaptured, boolean enPassant){
        this.origin = origin;
        this. destination = destination;
        this.pieceMoved = pieceMoved;
        this.pieceCaptured = pieceCaptured;
        this.enPassant = enPassant;
    }
}
