public class Board {
    private static Piece[][] board;
    private static Coordinates[] lastMove = new Coordinates[] {new Coordinates(0,0), new Coordinates(0,0)};

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
        lastMove[0] = origin;
        lastMove[1] = destination;
        return returnPiece;
    }

    public static Coordinates[] Get_Last_Move(){
        return lastMove;
    }

    private static Piece[][] Generate_Standard(){
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
