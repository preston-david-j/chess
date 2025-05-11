public class Debug {
    public static void DisplayBoard(){
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
}
