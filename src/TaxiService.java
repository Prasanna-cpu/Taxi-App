import java.util.ArrayList;
import java.util.List;

public class TaxiService {

    private final List<Taxi> taxis;

    private final List<Booking> bookings;

    private int bookingCounter;

    public TaxiService(int numberOfTaxis){
        taxis=new ArrayList<>();
        bookings=new ArrayList<>();
        bookingCounter=0;

        for(int i=1;i<=numberOfTaxis;i++){
            Taxi taxi=new Taxi(i);
            taxis.add(taxi);
        }

    }


    private Taxi findNearestAvailableTaxi(char pickUpPoint,int pickUpTime){
        Taxi nearestTaxi=null;


        for(Taxi taxi:taxis){
            if(taxi.isAvailable() && taxi.getAvailableTime()<=pickUpTime){
                if (nearestTaxi==null || Math.abs(nearestTaxi.getCurrentLocation()-pickUpPoint) <= Math.abs(taxi.getCurrentLocation()-pickUpPoint) && taxi.getTotalEarnings()<nearestTaxi.getTotalEarnings()){
                    nearestTaxi=taxi;
                }


            }


        }
        return nearestTaxi;

    }


    public void bookTaxi(int customerId,char pickUpPoint,char dropPoint,int pickUpTime){

        Taxi allocatedTaxi=findNearestAvailableTaxi(pickUpPoint,pickUpTime);
        if(allocatedTaxi!=null){
            Booking booking=new Booking(bookingCounter,customerId,pickUpPoint,dropPoint,pickUpTime);
            bookingCounter++;
            allocatedTaxi.setCurrentLocation(dropPoint);
            allocatedTaxi.setAvailable(false);
            allocatedTaxi.setAvailableTime(booking.getDropTime());
            bookings.add(booking);

            System.out.println("Taxi Alloted");

            System.out.println("Taxi-"+allocatedTaxi.getTaxiId()+" is allocated");

        }

        else {
            System.out.println("No taxi available");
        }

    }

    public void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi-" + taxi.getTaxiId() + " Total Earnings: Rs." + taxi.getTotalEarnings());
            for (Booking booking : bookings) {
                if (taxi.getTaxiId() == booking.getBookingId()) {
                    System.out.println(booking.getBookingId() + "\t" + booking.getCustomerId() + "\t" +
                            booking.getPickUpPoint() + "\t" + booking.getDropPoint() + "\t" +
                            booking.getPickUpTime() + "\t" + booking.getDropTime() + "\t" +
                            booking.getFare());
                }
            }
        }
    }






}
