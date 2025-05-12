import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.event.*;

public class GraphicDriver implements ComponentListener{
    private static boolean firstRender = true;
    private static GraphicDriver instance = new GraphicDriver();
    
    private static JFrame frame = new JFrame();
    private static JPanel gamePanel = new JPanel(new GridLayout(8, 8, 0, 0));
    private static JButton[][] gameButtons = new JButton[8][8];
    private static HashMap<String, ImageIcon> imageCache = new HashMap<>();

    public static void Render_Graphics(PieceTypes.PieceSkin skin){
        if(firstRender){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,400);
            frame.setLayout(new BorderLayout());
            frame.setTitle("Local Chess Game");
            frame.addComponentListener(instance);

            gamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            gamePanel.setAlignmentY(Component.CENTER_ALIGNMENT);

            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    gameButtons[y][x] = new JButton();
                    gameButtons[y][x].setName(x + "," + y);
                    gameButtons[y][x].addActionListener(new GameDriver()); // replace with GameDriver
                    gameButtons[y][x].setBackground((x + y) % 2 == 0 ? Color.decode("#B88B4A") : Color.decode("#E3C16F"));

                    Configure_Button(gameButtons[y][x]);
                    gamePanel.add(gameButtons[y][x]);
                }
            }
            
            frame.add(gamePanel, BorderLayout.CENTER);
            frame.setVisible(true);
            firstRender = false;
        }

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
            }
        }
    }

    public void componentResized(ComponentEvent e){
        imageCache.clear();
        Render_Graphics(PieceTypes.activeSkin);
    }

    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {}

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
        Image scaledImage = currentImage.getImage().getScaledInstance(frame.getWidth() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        imageCache.put(path, scaledIcon);
        return scaledIcon;
    }
}
