public class FlightStatusIncident  extends FlightStatus{

    private static FlightStatusIncident instance = null;

    private FlightStatusIncident(){};

    public static FlightStatusIncident getInstance(){
        if(instance == null){
            instance = new FlightStatusIncident();
        }
        return instance;
    }


    @Override
    public String getFlightStatusName() {
        return "INCIDENT";
    }
}
