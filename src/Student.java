public class Student {
    int id;
    int note1;
    int note2;
    int note3;
    int note4;
    double average;
    boolean approveDiscipline1 = false;
    boolean approveDiscipline2 = false;
    boolean approveDiscipline3 = false;
    boolean approveDiscipline4 = false;
    int year;

    public void getApprove(){
        if (note1>=70) {
            approveDiscipline1 = true;
        }if (note2>=70) {
            approveDiscipline2 = true;
        }if (note3>=70) {
            approveDiscipline3 = true;
        }if (note4>=70) {
            approveDiscipline4 = true;
        }
    }

    public void getAverage(){
        average = (double) (note1+note2+note3+note4)/4;
    }
    
    public Student(String values, String values2, String values3, String values4, String values5, String values6) {
        this.id = Integer.parseInt(values);
        this.note1 = Integer.parseInt(values2);
        this.note2 = Integer.parseInt(values3);
        this.note3 = Integer.parseInt(values4);
        this.note4 = Integer.parseInt(values5);
        this.year = Integer.parseInt(values6);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote1() {
        return note1;
    }

    public void setNote1(int note1) {
        this.note1 = note1;
    }

    public int getNote2() {
        return note2;
    }

    public void setNote2(int note2) {
        this.note2 = note2;
    }

    public int getNote3() {
        return note3;
    }

    public void setNote3(int note3) {
        this.note3 = note3;
    }

    public int getNote4() {
        return note4;
    }

    public void setNote4(int note4) {
        this.note4 = note4;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
