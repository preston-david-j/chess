import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GameDriver implements ActionListener{
    private static Colours.Colour turn = Colours.Colour.white;
    private static Coordinates currentCoordinates = new Coordinates(4, 4);

    public void actionPerformed(ActionEvent e){
        Piece currentPiece = Board.Get_Piece(currentCoordinates);
        JButton sourceButton = (JButton)e.getSource();
        Coordinates currentClick = new Coordinates(sourceButton.getName());

        boolean moveOccured = false;

        if(currentCoordinates.Validate()){
            System.out.println("here-2!");
            if(currentPiece != null && currentPiece.colour == turn){
                System.out.println("here-1!");
                if(currentCoordinates != currentClick){
                    System.out.println("here!");
                    moveOccured = currentPiece.Move(currentCoordinates, currentClick);
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

        System.out.println(currentCoordinates.X() + " " + currentCoordinates.Y());
        GraphicDriver.Render_Graphics(PieceTypes.PieceSkin.Alpha);
    }
}
