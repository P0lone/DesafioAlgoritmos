import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Menu extends JPanel{
    Button button;
    
    public Menu(){}

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        button.paint();
    }
}
