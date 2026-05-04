public class FlightStatusDelayedScheduled extends FlightStatusDelayed{
    
    private static FlightStatusDelayedScheduled instance = null;
    
    private FlightStatusDelayedScheduled(){};
    
    public static FlightStatusDelayedScheduled getInstance(){
        if(instance == null){
            instance = new FlightStatusDelayedScheduled();
        }
        return instance;
    }


    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusScheduled.getInstance());
        return true;
    }

    @Override
    public boolean proceed(Flight flight) {
        flight.setStatus(FlightStatusInbound.getInstance());
        return true;
    }

}
