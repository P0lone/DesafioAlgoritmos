import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        Text text = new Text();
        text.getText();
        HashMap<Integer, Student> textMap = text.readText();
        AverageYear.getMap(textMap);
        AverageYear.getAverageYear(textMap);
        AverageYear.getMedianYear(textMap);
        AverageYear.getStandardDeviationYear(textMap);
        AverageDiscipline.getAverage(textMap);
        AverageDiscipline.getStandardDeviation(textMap);
        AverageDiscipline.getMedian(textMap);
        System.out.println(textMap.size());
    }
}
