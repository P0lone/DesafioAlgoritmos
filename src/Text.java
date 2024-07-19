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

    public HashMap<Integer, Student> readText() {
        HashMap<Integer, Student> text = new HashMap<Integer, Student>();
        String line;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");           
                Student student = new Student(values[0], values[1], values[2], values[3], values[4], values[5]);
                student.getApprove();
                student.getAverage();
                text.put(i, student);
                System.out.println(student.average);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}