import java.io.File;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

public class Text {
    File file;
    Pattern pattern;

    public Text(){}

    public void getText(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            this.file = fileChooser.getSelectedFile();
        }else{
            System.out.println("Nenhum arquivo selecionado");
        }
    }
}