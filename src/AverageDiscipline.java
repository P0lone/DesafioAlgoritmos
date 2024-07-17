import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AverageDiscipline {
    static double[] average = new double[4];
    static double sum1;
    static double sum2;
    static double sum3;
    static double sum4;
    public static void getAverage(HashMap<Integer, Student> text) {
        double[] discipline = new double[4];
        for (int i = 0; i < text.size(); i++) {
            Student student = text.get(i);
            discipline[0] += student.getNote1();
            discipline[1] += student.getNote2();
            discipline[2] += student.getNote3();
            discipline[3] += student.getNote4();
        }
        for (int i =0; i<discipline.length;i++) {
            average[i] = discipline[i]/text.size();
            System.out.println("Media da Disciplina "+(i+1)+": "+average[i]);
        }
    }

    public static void getMedian(HashMap<Integer, Student> text){
        ArrayList<Integer> notes1 = new ArrayList<>();
        ArrayList<Integer> notes2 = new ArrayList<>();
        ArrayList<Integer> notes3 = new ArrayList<>();
        ArrayList<Integer> notes4 = new ArrayList<>();
        double median1 = 0;
        double median2 = 0;
        double median3 = 0;
        double median4 = 0;
        text.forEach((id, student) -> {
            notes1.add(student.getNote1());
            notes2.add(student.getNote2());
            notes3.add(student.getNote3());
            notes4.add(student.getNote4());
        });
        Collections.sort(notes1);
        if(text.size()%2==0){
            int mid = text.size()/2;
            median1 = (notes1.get(mid)+notes1.get(mid-1))/2;
            median2 = (notes2.get(mid)+notes2.get(mid-1))/2;
            median3 = (notes3.get(mid)+notes3.get(mid-1))/2;
            median4 = (notes4.get(mid)+notes4.get(mid-1))/2;
        }else{
            int mid = text.size()/2;
            median1 = (notes1.get(mid-1)+1)/2;
            median2 = (notes2.get(mid-1)+1)/2;
            median3 = (notes3.get(mid-1)+1)/2;
            median4 = (notes4.get(mid-1)+1)/2;
        }
        System.out.println("Mediana Disciplina 1: "+median1);
        System.out.println("Mediana Disciplina 2: "+median2);
        System.out.println("Mediana Disciplina 3: "+median3);
        System.out.println("Mediana Disciplina 4: "+median4);
    }

    public static void getStandardDeviation(HashMap<Integer, Student> text){
        text.forEach((id, student) -> {
            double x1 = student.getNote1();
            double x2 = student.getNote2();
            double x3 = student.getNote3();
            double x4 = student.getNote4();
            sum1 += Math.pow((x1-average[0]),2);
            sum2 += Math.pow((x2-average[1]),2);
            sum3 += Math.pow((x3-average[2]),2);
            sum4 += Math.pow((x4-average[3]),2);
        });
        
        double dp1 = Math.sqrt(sum1/text.size());
        double dp2 = Math.sqrt(sum2/text.size());
        double dp3 = Math.sqrt(sum3/text.size());
        double dp4 = Math.sqrt(sum4/text.size());
        System.out.println(dp1);
        System.out.println(dp2);
        System.out.println(dp3);
        System.out.println(dp4);
    }
}
