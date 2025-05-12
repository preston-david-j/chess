import java.util.List;
import java.util.ArrayList;

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
        Coordinates[] validMoves = Valid_Moves(origin);

        for(int i = 0; i < validMoves.length; i++){
            if(validMoves[i].Equals(destination)){
                this.moved = true;
                if(destination.X() != origin.X() && Board.Get_Piece(destination) == null){
                    Board.En_Passant(origin, destination);
                }
                else{
                    Board.Move(origin, destination);
                }
                return true;
            }
        }

        return false;
    }

    public Piece Copy(){
        return new Pawn(this.colour, this.moved);
    }

    public Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }

    public Coordinates[] Valid_Moves(Coordinates origin){
        List<Coordinates> moves = new ArrayList<>();

        int direction = (this.colour == Colours.Colour.white) ? -1 : 1;
        int maxSteps = moved ? 1 : 2;

        // Forward Movement Logic
        for (int i = 1; i <= maxSteps; i++) {
            Coordinates step = origin.Copy();
            step.Set_Y(step.Y() + i * direction);

            if (!step.Validate() || Board.Get_Piece(step) != null) break;
            moves.add(step);
        }


        Coordinates enPassantPosition = origin.Copy();
        enPassantPosition.Set_X(enPassantPosition.X() - 1);

        Coordinates captureCoordinates = origin.Copy();
        captureCoordinates.Set_Y(captureCoordinates.Y() + direction);
        captureCoordinates.Set_X(captureCoordinates.X() - 1);

        if(Check_Capture_Possible(captureCoordinates, enPassantPosition)){
            moves.add(captureCoordinates.Copy());
        }

        enPassantPosition.Set_X(enPassantPosition.X() + 2);
        captureCoordinates.Set_X(captureCoordinates.X() + 2);

        if(Check_Capture_Possible(captureCoordinates, enPassantPosition)){
            moves.add(captureCoordinates.Copy());
        }

        return moves.toArray(new Coordinates[moves.size()]);
    }

    private boolean Check_Capture_Possible(Coordinates captureCoordinates, Coordinates enPassantPosition){
        return captureCoordinates.Validate() && 
        (Board.Get_Piece(captureCoordinates) != null || 
        (Board.Get_Piece(enPassantPosition) instanceof Pawn &&
        Board.Get_Last_Move().destination.Equals(enPassantPosition) && 
        Math.abs(Board.Get_Last_Move().destination.Y() - Board.Get_Last_Move().origin.Y()) == 2 ));
    }
}
