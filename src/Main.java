import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws Exception {
        Text text = new Text();
        text.getText();
        Calc.getAverageYear(text.readText());
    }
}
