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
            validMoves[i].Display();
            if(validMoves[i].Equals(destination)){
                Board.Move(origin, destination);
                this.moved = true;
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
        Coordinates originCopy = origin.Copy();

        for(int i = 1; i < 3; i++){
            if(this.colour == Colours.Colour.white){
                originCopy.Set_Y(originCopy.Y() - 1);
            }
            else{
                originCopy.Set_Y(originCopy.Y() + 1);
            }

            if(originCopy.Validate()){
                moves.add(originCopy.Copy());
            }
            else{
                break;
            }
        }

        return moves.toArray(new Coordinates[moves.size()]);
    }
}
