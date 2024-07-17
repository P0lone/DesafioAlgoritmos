import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Text {
    File file;
    String path;

    public Text() {
    }

    public void getText() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.file = fileChooser.getSelectedFile();
            this.path = this.file.getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado");
        }
    }

    public HashMap<Integer, Integer[]> readText() {
        HashMap<Integer, Integer[]> text = new HashMap<Integer, Integer[]>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}