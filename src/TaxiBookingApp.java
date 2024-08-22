import java.util.Scanner;

public class TaxiBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaxiService taxiService = new TaxiService(4);

        taxiService.bookTaxi(1, 'A', 'B', 9);
        taxiService.bookTaxi(2, 'B', 'D', 9);
        taxiService.bookTaxi(3, 'B', 'C', 12);

        taxiService.displayTaxiDetails();
    }
}
