import java.text.SimpleDateFormat;
import java.util.Date;

public class Debug {
    public static void Display_Board(){
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(Board.Get_Piece(new Coordinates(x, y)) == null){
                    System.out.print("empty - ");
                }
                else{
                    System.out.print(Board.Get_Piece(new Coordinates(x, y)).colour + " " + Board.Get_Piece(new Coordinates(x, y)).type + " - ");
                }
            }
            System.out.println();
        }
    }

    public static void Timestamped_Message(String message){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDate = sdf.format(new Date());
        System.out.println("[" + formattedDate + "]: " + message);
    }
}
