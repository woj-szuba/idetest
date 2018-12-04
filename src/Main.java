import java.util.Random;


public class Main {

    public static void main(String[] args) {

        System.out.println("Symulator rzutu kostką");
        System.out.print("Wynik: ");
        Random kostka = new Random();
        int i = kostka.nextInt(6) +1;

        System.out.println(i);
    }
}
