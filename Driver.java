public class Driver {
    public static void main(String[] args){
        Board.Generate_Board(Board.BoardType.standard);
        GraphicDriver.Render_Graphics(PieceTypes.activeSkin);
    }
}
