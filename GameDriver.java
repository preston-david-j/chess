import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GameDriver implements ActionListener{
    private static Colours.Colour turn = Colours.Colour.white;
    private static Coordinates currentCoordinates = new Coordinates(-1, -1);

    public void actionPerformed(ActionEvent e){
        JButton sourceButton = (JButton)e.getSource();
        Coordinates currentClick = new Coordinates(sourceButton.getName());

        currentClick.Display();

        boolean moveOccured = false;

        if(currentCoordinates.Validate()){
            Piece currentPiece = Board.Get_Piece(currentCoordinates);
            Piece destinationPiece = Board.Get_Piece(currentClick);

            if(currentPiece != null && currentPiece.colour == turn){
                if(currentCoordinates != currentClick){
                    if(destinationPiece != null){
                        if(destinationPiece.colour != currentPiece.colour){
                            moveOccured = currentPiece.Move(currentCoordinates, currentClick);
                        }
                    }
                    else{
                        moveOccured = currentPiece.Move(currentCoordinates, currentClick);
                    }
                }
                else{
                    currentCoordinates = new Coordinates(-1, -1);
                }
            }
        }

        if(moveOccured){
            if(turn == Colours.Colour.white){turn = Colours.Colour.black;}
            else{turn = Colours.Colour.white;}
        }
        else{
            currentCoordinates = currentClick;
        }
        
        GraphicDriver.Render_Graphics(PieceTypes.PieceSkin.Alpha);
    }
}
