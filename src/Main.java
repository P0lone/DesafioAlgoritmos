import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        Text text = new Text();
        JFrame window = new JFrame("Estatísticas Notas");
        Menu menu = new Menu();
        window.add(menu);
		window.setSize(720, 480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.getText();
    }
}
