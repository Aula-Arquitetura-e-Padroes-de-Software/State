public class FlightStatusDivertedDeparted extends FlightStatusDiverted{

    private static FlightStatusDivertedDeparted instance = null;

    private FlightStatusDivertedDeparted(){};

    public static FlightStatusDivertedDeparted getInstance(){
        if(instance == null){
            instance = new FlightStatusDivertedDeparted();
        }
        return instance;
    }

    @Override
    public boolean resume(Flight flight) {
        flight.setStatus(FlightStatusDeparted.getInstance());
        return true;
    }

}
