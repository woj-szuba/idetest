public class Date {

    private int year, month, day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString(){
        System.out.println(day + "/" + month + "/" + year);
        return null;
    }
}

