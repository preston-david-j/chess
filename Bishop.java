import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(Colours.Colour colour){
        this.type = PieceTypes.PieceType.bishop;
        this.colour = colour;
        this.value = 3;
    }

    public boolean Move(Coordinates origin, Coordinates destination){
        Coordinates[] validMoves = Valid_Moves(origin);

        for(int i = 0; i < validMoves.length; i++){
            if(validMoves[i].Equals(destination)){
                Board.Move(origin, destination);
                return true;
            }
        }

        return false;
    }   

    public Piece Copy(){
        return new Bishop(this.colour);
    }

    public Coordinates[] Attack_Trace(){
        return new Coordinates[0];
    }

    public Coordinates[] Valid_Moves(Coordinates origin){
        
        List<Coordinates> validMoves = new ArrayList<>();

        for(int ydif = 0; ydif < 7; ydif++){
            for(int xdif = 0; xdif < 7; xdif++){
                Coordinates nn = origin.Copy();
                Coordinates pn = origin.Copy();
                Coordinates np = origin.Copy();
                Coordinates pp = origin.Copy();

                nn.Display();
                pn.Display();
                np.Display();
                pp.Display();

                nn.Set(origin.X() - xdif, origin.Y() - ydif);
                pn.Set(origin.X() + xdif, origin.Y() - ydif); 
                np.Set(origin.X() - xdif, origin.Y() + ydif);  
                pp.Set(origin.X() + xdif, origin.Y() + ydif);
                
                if(nn.Validate()){validMoves.add(nn);}
                if(pn.Validate()){validMoves.add(pn);}
                if(np.Validate()){validMoves.add(np);}
                if(pp.Validate()){validMoves.add(pp);}
            }
        }

        return validMoves.toArray(new Coordinates[validMoves.size()]);
    }
}
