import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws Exception {
        Text text = new Text();
        JFrame window = new JFrame("Estatisticas Notas");
        JButton buttonGetFile = new JButton("Pegar arquivo");
        buttonGetFile.setBounds(25, 25, 200, 30);
        buttonGetFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.getText();
            }
        });
        window.add(buttonGetFile);
		window.setSize(720, 480);
        window.setLayout(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
