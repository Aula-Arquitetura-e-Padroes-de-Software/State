public class FlightStatusCancelled extends FlightStatus{
    private static FlightStatusCancelled instance = null;

    private FlightStatusCancelled(){};

    public static FlightStatusCancelled getInstance(){
        if(instance == null){
            instance = new FlightStatusCancelled();
        }
        return instance;
    }


    @Override
    public String getFlightStatusName() {
        return "CANCELLED";
    }
}
