public class FlightStatusDivertedEnRoute extends FlightStatusDiverted{

    private static FlightStatusDivertedEnRoute instance = null;

    private FlightStatusDivertedEnRoute(){};

    public static FlightStatusDivertedEnRoute getInstance(){
        if(instance == null){
            instance = new FlightStatusDivertedEnRoute();
        }
        return instance;
    }

    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusEnRoute.getInstance());
        return true;
    }


}
