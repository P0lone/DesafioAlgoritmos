import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AverageYear {
    private static HashMap<Integer, ArrayList<Integer>> years = new HashMap<Integer, ArrayList<Integer>>();
    private static HashMap<Integer, ArrayList<Double>> average = new HashMap<Integer, ArrayList<Double>>();

    public static void getMap(HashMap<Integer, Student> text) {
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
            ArrayList<Double> note = new ArrayList<>();
            note.add(0, u[0]/u[4]);
            note.add(1, u[1]/u[4]);
            note.add(2, u[2]/u[4]);
            note.add(3, u[3]/u[4]);
            average.put(t, note);
            System.out.println("Media do ano " + t);
            System.out.println("Media Disiciplina 1: " + u[0] / u[4]);
            System.out.println("Media Disiciplina 2: " + u[1] / u[4]);
            System.out.println("Media Disiciplina 3: " + u[2] / u[4]);
            System.out.println("Media Disiciplina 4: " + u[3] / u[4]);
        });
    }

    public static void getMedianYear(HashMap<Integer, Student> text) {
        HashMap<Integer,Double> notes1 = new HashMap<Integer,Double>();
        HashMap<Integer,Double> notes2 = new HashMap<Integer,Double>();
        HashMap<Integer,Double> notes3 = new HashMap<Integer,Double>();
        HashMap<Integer,Double> notes4 = new HashMap<Integer,Double>();
        years.forEach((year, ids) -> {
            ArrayList<Integer> note1 = new ArrayList<>();
            ArrayList<Integer> note2 = new ArrayList<>();
            ArrayList<Integer> note3 = new ArrayList<>();
            ArrayList<Integer> note4 = new ArrayList<>();
            for(int i = 0;i<ids.size();i++){
                if(text.containsKey(ids.get(i))){
                    Student student = text.get(ids.get(i));
                    note1.add(student.getNote1());
                    note2.add(student.getNote2());
                    note3.add(student.getNote3());
                    note4.add(student.getNote4());
                }
            }
            Collections.sort(note1);
            double median1 = 0;
            double median2 = 0;
            double median3 = 0;
            double median4 = 0;
            if(ids.size()%2==0){
                int mid = ids.size()/2;
                median1 = (double) (note1.get(mid)+note1.get(mid+1))/2;
                median2 = (double) (note2.get(mid)+note2.get(mid+1))/2;
                median3 = (double) (note3.get(mid)+note3.get(mid+1))/2;
                median4 = (double) (note4.get(mid)+note4.get(mid+1))/2;
            }else{
                int mid = ids.size()/2;
                median1 = (note1.get(mid)+1)/2;
                median2 = (note2.get(mid)+1)/2;
                median3 = (note3.get(mid)+1)/2;
                median4 = (note4.get(mid)+1)/2;
            }
            notes1.put(year, median1);
            notes2.put(year, median2);
            notes3.put(year, median3);
            notes4.put(year, median4);
        });
        System.out.println(notes1.keySet());
        System.out.println(notes1.values());
        System.out.println(notes2.values());
        System.out.println(notes3.values());
        System.out.println(notes4.values());
    }

    public static void getStandardDeviationYear(HashMap<Integer, Student> text) {
        years.forEach((year, ids) ->{
            double sum1 = 0;
            double sum2 = 0;
            double sum3 = 0;
            double sum4 = 0;
            for(int i = 0;i<ids.size();i++){
                if(text.containsKey(ids.get(i))){
                    Student student = text.get(ids.get(i));
                    double x1 = student.getNote1();
                    double x2 = student.getNote2();
                    double x3 = student.getNote3();
                    double x4 = student.getNote4();
                    ArrayList<Double> average1 = average.get(student.getYear());
                    sum1 += Math.pow((x1-average1.get(0)),2);
                    sum2 += Math.pow((x2-average1.get(1)),2);
                    sum3 += Math.pow((x3-average1.get(2)),2);
                    sum4 += Math.pow((x4-average1.get(3)),2);
                }
            }
            System.out.println(Math.sqrt(sum1/ids.size()));
            System.out.println(Math.sqrt(sum2/ids.size()));
            System.out.println(Math.sqrt(sum3/ids.size()));
            System.out.println(Math.sqrt(sum4/ids.size()));
        } );
    }
}
