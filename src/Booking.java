public class Booking {

    private final int bookingId;
    private final int customerId;
    private final char pickUpPoint;
    private final char dropPoint;
    private final int dropTime;
    private final int fare;
    private final int pickUpTime;



    public Booking(int bookingId, int customerId, char pickUpPoint, char dropPoint,int pickUpTime) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickUpPoint = pickUpPoint;
        this.dropPoint = dropPoint;
        this.pickUpTime = pickUpTime;
        this.dropTime = pickUpTime+(Math.abs(dropPoint-pickUpPoint)*60/15) ;
        this.fare = calculateFare();
    }

    private int calculateFare(){
        int distance=Math.abs(dropPoint-pickUpPoint)*15;

        if(distance<=5){
            return 100;
        }
        else{
            return 100+(distance-5)*10;
        }

    }

    public int getBookingId(){
        return bookingId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public char getPickUpPoint(){
        return pickUpPoint;
    }

    public char getDropPoint(){
        return dropPoint;
    }

    public int getPickUpTime(){
        return pickUpTime;
    }

    public int getDropTime(){
        return dropTime;
    }

    public int getFare(){
        return fare;
    }




}
