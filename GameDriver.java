import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GameDriver implements ActionListener{
    public static Colours.Colour turn;
    public static Coordinates currentCoordinates;

    public void actionPerformed(ActionEvent e){
        Piece currentPiece = Board.Get_Piece(currentCoordinates);
        JButton sourceButton = (JButton)e.getSource();
        Coordinates currentClick = new Coordinates(sourceButton.getName());

        boolean moveOccured = false;

        if(currentCoordinates.Validate()){
            if(currentPiece != null && currentPiece.colour == turn){
                if(currentCoordinates != currentClick){
                    moveOccured = currentPiece.Move(currentCoordinates, currentClick);
                }
                else{
                    currentCoordinates = new Coordinates(-1, -1);
                }
            }
        }
    }
}
