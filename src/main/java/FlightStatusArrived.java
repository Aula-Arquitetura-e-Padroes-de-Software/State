public class FlightStatusArrived extends FlightStatus{

    private static FlightStatusArrived instance = null;

    private FlightStatusArrived(){};

    public static FlightStatusArrived getInstance(){
        if(instance == null){
            instance = new FlightStatusArrived();
        }
        return instance;
    }

    @Override
    public String getFlightStatusName() {
        return "ARRIVED";
    }
}
