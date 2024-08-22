public class Taxi {

    private final int taxiId;
    private int totalEarnings;
    private char currentLocation;
    private boolean isAvailable;
    private int availableTime;

    public Taxi(int taxiId){
        this.taxiId=taxiId;
        this.totalEarnings=0;
        this.currentLocation='A';
        this.isAvailable=true;
        this.availableTime=0;
    }

    public int getTaxiId(){
        return taxiId;
    }

    public char getCurrentLocation(){
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation){
        this.currentLocation=currentLocation;
    }

    public int getTotalEarnings(){
        return totalEarnings;
    }

    public void addEarnings(int addEarnings){
        totalEarnings+=addEarnings;
    }

    public boolean isAvailable(){
        return isAvailable;

    }

    public void setAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
    }

    public int getAvailableTime(){
        return availableTime;
    }

    public void setAvailableTime(int availableTime){
        this.availableTime=availableTime;
    }


}
