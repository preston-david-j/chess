import javax.swing.*;
import java.awt.*;

public class GraphicDriver {
    public static boolean firstRender = false;

    public static JFrame frame = new JFrame();
    public static JPanel gamePanel = new JPanel(new GridLayout(8,8));
    public static JButton[][] gameButtons = new JButton[8][8];

    public void Render_Graphics(){
        if(firstRender){
            frame.setSize(400,400);
            frame.setResizable(false);
            frame.setTitle("Local Chess Game");

            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    gameButtons[y][x] = new JButton();
                    gameButtons[y][x].setName(x + "," + y);
                    gameButtons[y][x].addActionListener(null); // replace with GameDriver
                    Configure_Button(gameButtons[x][y]);
                }
            }
            
            frame.add(gamePanel);

            firstRender = false;
            frame.setVisible(true);
        }

        gamePanel.removeAll();
        gamePanel.revalidate();

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                
            }
        }

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    private void Configure_Button(JButton button){
        button.setText(null);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
    }
}
