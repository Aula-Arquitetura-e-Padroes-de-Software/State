import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    // ===== Initial state =====

    @Test
    void testInitialStateIsScheduled() {
        Flight flight = new Flight("LA3471", "CNF");
        assertEquals("SCHEDULED", flight.getFlightStatusName());
    }

    // ===== Happy path =====

    @Test
    void testProceedFromScheduledToInbound() {
        Flight flight = new Flight("LA3471", "CNF");
        assertTrue(flight.proceed());
        assertEquals("INBOUND", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromInboundToBoarding() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        assertTrue(flight.proceed());
        assertEquals("BOARDING", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromBoardingToLastCall() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        assertTrue(flight.proceed());
        assertEquals("LAST CALL", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromLastCallToDeparted() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        assertTrue(flight.proceed());
        assertEquals("DEPARTED", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromDepartedToEnRoute() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        assertTrue(flight.proceed());
        assertEquals("EN ROUTE", flight.getFlightStatusName());
    }

    @Test
    void testLandFromEnRouteToArrived() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        assertTrue(flight.land());
        assertEquals("ARRIVED", flight.getFlightStatusName());
    }

    // ===== Delay and resume =====

    @Test
    void testDelayFromScheduledGoesToDelayed() {
        Flight flight = new Flight("LA3471", "CNF");
        assertTrue(flight.delay());
        assertEquals("DELAYED", flight.getFlightStatusName());
    }

    @Test
    void testResumeFromDelayedScheduledGoesBackToScheduled() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.delay();
        assertTrue(flight.resume());
        assertEquals("SCHEDULED", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromDelayedScheduledGoesToInbound() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.delay();
        assertTrue(flight.proceed());
        assertEquals("INBOUND", flight.getFlightStatusName());
    }

    @Test
    void testDelayFromBoardingGoesToDelayed() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        assertTrue(flight.delay());
        assertEquals("DELAYED", flight.getFlightStatusName());
    }

    @Test
    void testResumeFromDelayedBoardingGoesBackToBoarding() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.delay();
        assertTrue(flight.resume());
        assertEquals("BOARDING", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromDelayedBoardingGoesToLastCall() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.delay();
        assertTrue(flight.proceed());
        assertEquals("LAST CALL", flight.getFlightStatusName());
    }

    // ===== Cancel =====

    @Test
    void testCancelFromScheduledGoesToCancelled() {
        Flight flight = new Flight("LA3471", "CNF");
        assertTrue(flight.cancel());
        assertEquals("CANCELLED", flight.getFlightStatusName());
    }

    @Test
    void testCancelFromBoardingGoesToCancelled() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        assertTrue(flight.cancel());
        assertEquals("CANCELLED", flight.getFlightStatusName());
    }

    @Test
    void testCancelFromDelayedGoesToCancelled() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.delay();
        assertTrue(flight.cancel());
        assertEquals("CANCELLED", flight.getFlightStatusName());
    }

    // ===== Divert =====

    @Test
    void testDivertFromDepartedGoesToDiverted() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        assertTrue(flight.divert());
        assertEquals("DIVERTED", flight.getFlightStatusName());
    }

    @Test
    void testDivertFromEnRouteGoesToDiverted() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        assertTrue(flight.divert());
        assertEquals("DIVERTED", flight.getFlightStatusName());
    }

    @Test
    void testLandFromDivertedEnRouteGoesToArrived() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.divert();
        assertTrue(flight.land());
        assertEquals("ARRIVED", flight.getFlightStatusName());
    }

    @Test
    void testResumeFromDivertedEnRouteGoesBackToEnRoute() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.divert();
        assertTrue(flight.resume());
        assertEquals("EN ROUTE", flight.getFlightStatusName());
    }

    // ===== Emergency =====

    @Test
    void testEmergencyFromEnRouteGoesToEmergency() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        assertTrue(flight.emergency());
        assertEquals("SEE COUNTER", flight.getFlightStatusName());
    }

    @Test
    void testResumeFromEmergencyEnRouteGoesBackToEnRoute() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.emergency();
        assertTrue(flight.resume());
        assertEquals("EN ROUTE", flight.getFlightStatusName());
    }

    @Test
    void testAccidentFromEmergencyGoesToIncident() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.emergency();
        assertTrue(flight.accident());
        assertEquals("INCIDENT", flight.getFlightStatusName());
    }

    @Test
    void testDivertFromEmergencyEnRouteGoesToDiverted() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.emergency();
        assertTrue(flight.divert());
        assertEquals("DIVERTED", flight.getFlightStatusName());
    }

    // ===== Invalid transitions =====

    @Test
    void testLandFromScheduledIsInvalid() {
        Flight flight = new Flight("LA3471", "CNF");
        assertFalse(flight.land());
        assertEquals("SCHEDULED", flight.getFlightStatusName());
    }

    @Test
    void testDivertFromScheduledIsInvalid() {
        Flight flight = new Flight("LA3471", "CNF");
        assertFalse(flight.divert());
        assertEquals("SCHEDULED", flight.getFlightStatusName());
    }

    @Test
    void testEmergencyFromScheduledIsInvalid() {
        Flight flight = new Flight("LA3471", "CNF");
        assertFalse(flight.emergency());
        assertEquals("SCHEDULED", flight.getFlightStatusName());
    }

    @Test
    void testResumeFromScheduledIsInvalid() {
        Flight flight = new Flight("LA3471", "CNF");
        assertFalse(flight.resume());
        assertEquals("SCHEDULED", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromArrivedIsInvalid() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.proceed();
        flight.land();
        assertFalse(flight.proceed());
        assertFalse(flight.cancel());
        assertFalse(flight.delay());
        assertEquals("ARRIVED", flight.getFlightStatusName());
    }

    @Test
    void testProceedFromCancelledIsInvalid() {
        Flight flight = new Flight("LA3471", "CNF");
        flight.cancel();
        assertFalse(flight.proceed());
        assertFalse(flight.resume());
        assertFalse(flight.delay());
        assertEquals("CANCELLED", flight.getFlightStatusName());
    }
}