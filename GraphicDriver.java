import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GraphicDriver {
    private static boolean firstRender = true;

    public static JFrame frame = new JFrame();
    public static JPanel gamePanel = new JPanel(new GridLayout(8, 8, 0, 0));
    public static JButton[][] gameButtons = new JButton[8][8];
    public static HashMap<String, ImageIcon> imageCache = new HashMap<>();

    public static void Render_Graphics(PieceTypes.PieceSkin skin){
        if(firstRender){
            frame.setDefaultCloseOperation(3);
            frame.setLayout(new BorderLayout());
            frame.setSize(400,397);
            frame.setResizable(false);
            frame.setTitle("Local Chess Game");

            gamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            gamePanel.setAlignmentY(Component.CENTER_ALIGNMENT);

            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    gameButtons[y][x] = new JButton();
                    gameButtons[y][x].setPreferredSize(new Dimension(50, 50));
                    gameButtons[y][x].setName(x + "," + y);
                    gameButtons[y][x].addActionListener(new GameDriver()); // replace with GameDriver
                    gameButtons[y][x].setBackground((x + y) % 2 == 0 ? Color.decode("#B88B4A") : Color.decode("#E3C16F"));

                    Configure_Button(gameButtons[y][x]);
                }
            }
            
            frame.add(gamePanel, BorderLayout.CENTER);
            frame.setVisible(true);
            firstRender = false;
        }
        
        gamePanel.removeAll();

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                Coordinates current = new Coordinates(x, y);

                if(Board.Get_Piece(new Coordinates(x, y)) != null){
                    String path = "Pieces/" + skin + "/" + Board.Get_Piece(current).colour + "-" + Board.Get_Piece(current).type + ".png";
                    gameButtons[y][x].setIcon(Get_Scaled_Icon(path));
                }
                else{
                    gameButtons[y][x].setIcon(null);
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

    private static ImageIcon Get_Scaled_Icon(String path){
        if (imageCache.containsKey(path)){
            return imageCache.get(path);
        }

        ImageIcon currentImage = new ImageIcon(path);
        Image scaledImage = currentImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        imageCache.put(path, scaledIcon);
        return scaledIcon;
    }
}
