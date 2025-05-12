import java.util.List;
import java.util.ArrayList;

public class Board {
    private static Piece[][] board;
    private static List<Move> history = new ArrayList<>();

    public static void Generate_Board(BoardType type){
        switch(type){
            case standard: board = Generate_Standard(); break;
            default: return;
        }
    }

    public static enum BoardType{
        standard,
        tiled,
        random
    }

    public static Piece Get_Piece(Coordinates coordinates){
        return board[coordinates.Y()][coordinates.X()];
    }

    public static Piece Move(Coordinates origin, Coordinates destination){
        Piece returnPiece = Get_Piece(destination);
        board[destination.Y()][destination.X()] = board[origin.Y()][origin.X()].Copy();
        board[origin.Y()][origin.X()] = null;
        history.add(new Move(origin, destination, Get_Piece(destination), returnPiece, false));

        return returnPiece;
    }

    public static Piece En_Passant(Coordinates origin, Coordinates destination){
        Coordinates returnCoordinates = new Coordinates(destination.X(), origin.Y());
        Piece returnPiece = Get_Piece(returnCoordinates);
        board[destination.Y()][destination.X()] = board[origin.Y()][origin.X()].Copy();
        board[origin.Y()][origin.X()] = null;
        board[returnCoordinates.Y()][returnCoordinates.X()] = null;
        history.add(new Move(origin, destination, Get_Piece(destination), returnPiece, true));

        return returnPiece;
    }

    public static Move Get_Last_Move(){
        return history.getLast();
    }

    private static Piece[][] Generate_Standard(){
        history.add(new Move(new Coordinates(-1, -1), new Coordinates(-1, -1), null, null, false));
        return new Piece[][]
        {
            {new Rook(Colours.Colour.black), new Knight(Colours.Colour.black), new Bishop(Colours.Colour.black), new Queen(Colours.Colour.black),
            new King(Colours.Colour.black), new Bishop(Colours.Colour.black), new Knight(Colours.Colour.black), new Rook(Colours.Colour.black)},

            {new Pawn(Colours.Colour.black), new Pawn(Colours.Colour.black), new Pawn(Colours.Colour.black), new Pawn(Colours.Colour.black),
            new Pawn(Colours.Colour.black), new Pawn(Colours.Colour.black), new Pawn(Colours.Colour.black), new Pawn(Colours.Colour.black)},

            {null, null, null, null, null, null, null, null},

            {null, null, null, null, null, null, null, null},

            {null, null, null, null, null, null, null, null},

            {null, null, null, null, null, null, null, null},

            {new Pawn(Colours.Colour.white), new Pawn(Colours.Colour.white), new Pawn(Colours.Colour.white), new Pawn(Colours.Colour.white),
            new Pawn(Colours.Colour.white), new Pawn(Colours.Colour.white), new Pawn(Colours.Colour.white), new Pawn(Colours.Colour.white)},

            {new Rook(Colours.Colour.white), new Knight(Colours.Colour.white), new Bishop(Colours.Colour.white), new Queen(Colours.Colour.white),
            new King(Colours.Colour.white), new Bishop(Colours.Colour.white), new Knight(Colours.Colour.white), new Rook(Colours.Colour.white)},
        };
    }
}
