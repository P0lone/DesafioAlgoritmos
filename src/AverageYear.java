import java.util.HashMap;

public class AverageYear {
    private static HashMap<Integer, double[]> getMap(HashMap<Integer, Student> text) {
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
        return years;
    }

    public static void getAverageYear(HashMap<Integer, Student> text) {
        HashMap<Integer, double[]> years = getMap(text);
        years.forEach((t, u) -> {
            System.out.println("Media do ano " + t);
            System.out.println("Media Disiciplina 1: " + u[0]/u[4]);
            System.out.println("Media Disiciplina 2: " + u[1]/u[4]);
            System.out.println("Media Disiciplina 3: " + u[2]/u[4]);
            System.out.println("Media Disiciplina 4: " + u[3]/u[4]);
        });
    }

    public static void getMedianYear(HashMap<Integer, Student> text) {
        
    }

    public static void getStandardDeviationYear(){
        
    }
}
