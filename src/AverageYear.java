import java.util.ArrayList;
import java.util.HashMap;

public class AverageYear {
    private static HashMap<Integer, ArrayList<Integer>> years = new HashMap<Integer, ArrayList<Integer>>();

    private static void getMap(HashMap<Integer, Student> text) {
        text.forEach((id, student) -> {
            if (!years.containsKey(student.getYear())) {

                years.put(student.getYear(), new ArrayList<Integer>() {
                    {
                        add(0, id);
                    }
                });
            } else {
                ArrayList<Integer> ids = years.get(student.getYear());
                int index = ids.size();
                ids.add(index, id);
                years.replace(student.getYear(), ids);
            }
        });
    }

    public static void getAverageYear(HashMap<Integer, Student> text) {
        getMap(text);
        HashMap<Integer, double[]> years = new HashMap<Integer, double[]>();
        for (int i = 0; i < text.size(); i++) {
            Student student = text.get(i);
            if (!years.containsKey(student.getYear())) {
                double[] note = { student.getNote1(), student.getNote2(), student.getNote3(), student.getNote4(), 1 };
                years.put(student.getYear(), note);
            } else {
                double[] note = years.get(student.getYear());
                note[0] += student.getNote1();
                note[1] += student.getNote2();
                note[2] += student.getNote3();
                note[3] += student.getNote4();
                note[4]++;
                years.replace(student.getYear(), note);
            }
        }
        years.forEach((t, u) -> {
            System.out.println("Media do ano " + t);
            System.out.println("Media Disiciplina 1: " + u[0] / u[4]);
            System.out.println("Media Disiciplina 2: " + u[1] / u[4]);
            System.out.println("Media Disiciplina 3: " + u[2] / u[4]);
            System.out.println("Media Disiciplina 4: " + u[3] / u[4]);
        });
    }

    public static void getMedianYear(HashMap<Integer, Student> text) {
        getMap(text);
        
    }

    public static void getStandardDeviationYear() {

    }
}
