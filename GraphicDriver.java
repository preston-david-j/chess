import javax.swing.*;
import java.awt.*;

public class GraphicDriver {
    private static boolean firstRender = true;

    public static JFrame frame = new JFrame();
    public static JPanel gamePanel = new JPanel(new GridLayout(8,8));
    public static JButton[][] gameButtons = new JButton[8][8];

    public static void Render_Graphics(PieceTypes.PieceSkin skin){
        if(firstRender){
            frame.setDefaultCloseOperation(3);
            frame.setSize(400,400);
            frame.setResizable(false);
            frame.setTitle("Local Chess Game");

            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    gameButtons[y][x] = new JButton();
                    gameButtons[y][x].setName(x + "," + y);
                    gameButtons[y][x].addActionListener(null); // replace with GameDriver

                    if((x + y) % 2 == 0){
                        gameButtons[y][x].setBackground(Color.decode("#B88B4A"));
                    }
                    else{
                        gameButtons[y][x].setBackground(Color.decode("#E3C16F"));
                    }

                    Configure_Button(gameButtons[y][x]);
                }
            }
            
            frame.add(gamePanel);

            firstRender = false;
            frame.setVisible(true);
        }
        else{
            gamePanel.removeAll();
            gamePanel.revalidate();
        }

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                Coordinates current = new Coordinates(x, y);

                if(Board.Get_Piece(new Coordinates(x, y)) != null){
                    System.out.println("Pieces/" + skin + "/" + Board.Get_Piece(new Coordinates(x, y)).colour + "-" + Board.Get_Piece(new Coordinates(x, y)).type + ".png");
                    String path = "Pieces/" + skin + "/" + Board.Get_Piece(current).colour + "-" + Board.Get_Piece(current).type + ".png";
                    Image scaledImage = new ImageIcon(path).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    gameButtons[y][x].setIcon(new ImageIcon(scaledImage));

                }
                gamePanel.add(gameButtons[y][x]);
            }
        }

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    private static void Configure_Button(JButton button){
        button.setText(null);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
    }
}
