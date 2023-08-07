package com.examly.springapp.services;

import com.examly.springapp.model.Bus;
import com.examly.springapp.model.Flight;
import com.examly.springapp.model.Hotel;
import com.examly.springapp.model.Train;
import org.springframework.beans.factory.annotation.Autowired;


public class FareCalculator extends Booking{

    @Autowired
    private Bus bus;

    @Autowired
    private Hotel hotel;

    @Autowired
    private Train train;

    @Autowired
    private Flight flight;

    // public double book(Flight flight) {

    //     double totalFare = booking(flight.getNoOfPersons(),flight.getRates());
    
    //     if(flight.getTriptype().equalsIgnoreCase("one-way")){
    //         return totalFare;
    //     }else{
    //         int comp = (flight.getFrom()).compareTo(flight.getTo());
    //         if(comp < 0)
    //             return 2 * totalFare;
    //         else
    //             return 0;
    //     }
    // }

    // public double book(Bus bus) {
    //     double totalFare = booking(bus.getNoOfPersons(),bus.getRates());
    //     return totalFare;
    // }

    // public double book(Hotel hotel) {
    //     double totalFare = 0;
    //     if(hotel.getFromdate().isBefore(hotel.getTodate())){
    //         totalFare = booking(hotel.getNoOfPersons(), hotel.getRates());
    //     }
    //     return totalFare;
    // }

    // public double book(Train train) {
    //     double totalFare = booking(train.getNoOfPersons(),train.getRates());
    //     return totalFare;
    // }


    @Test
    public void testBookFlightOneWay() {
        FareCalculator fareCalculator = new FareCalculator();
        
        Flight mockFlight = mock(Flight.class);
        when(mockFlight.getNoOfPersons()).thenReturn(2);
        when(mockFlight.getRates()).thenReturn(3000);
        when(mockFlight.getTriptype()).thenReturn("one-way");

        double result = fareCalculator.book(mockFlight);
        assertEquals(6000, result, 0);
    }

    @Test
    public void testBookFlightRoundTrip() {
        FareCalculator fareCalculator = new FareCalculator();
        
        Flight mockFlight = mock(Flight.class);
        when(mockFlight.getNoOfPersons()).thenReturn(2);
        when(mockFlight.getRates()).thenReturn(3000);
        when(mockFlight.getTriptype()).thenReturn("round-trip");
        when(mockFlight.getFrom()).thenReturn("A");
        when(mockFlight.getTo()).thenReturn("B");

        double result = fareCalculator.book(mockFlight);
        assertEquals(12000, result, 0);
    }

    @Test
    public void testBookBus() {
        FareCalculator fareCalculator = new FareCalculator();
        
        Bus mockBus = mock(Bus.class);
        when(mockBus.getNoOfPersons()).thenReturn(3);
        when(mockBus.getRates()).thenReturn(1000);

        double result = fareCalculator.book(mockBus);
        assertEquals(3000, result, 0);
    }

    @Test
    public void testBookHotelValidDateRange() {
        FareCalculator fareCalculator = new FareCalculator();
        
        Hotel mockHotel = mock(Hotel.class);
        when(mockHotel.getNoOfPersons()).thenReturn(2);
        when(mockHotel.getRates()).thenReturn(1500);
        when(mockHotel.getFromdate()).thenReturn(LocalDate.of(2023, 8, 1));
        when(mockHotel.getTodate()).thenReturn(LocalDate.of(2023, 8, 3));

        double result = fareCalculator.book(mockHotel);
        assertEquals(3000, result, 0);
    }

    @Test
    public void testBookHotelInvalidDateRange() {
        FareCalculator fareCalculator = new FareCalculator();
        
        Hotel mockHotel = mock(Hotel.class);
        when(mockHotel.getFromdate()).thenReturn(LocalDate.of(2023, 8, 3));
        when(mockHotel.getTodate()).thenReturn(LocalDate.of(2023, 8, 1));

        double result = fareCalculator.book(mockHotel);
        assertEquals(0, result, 0);
    }

    @Test
    public void testBookTrain() {
        FareCalculator fareCalculator = new FareCalculator();
        
        Train mockTrain = mock(Train.class);
        when(mockTrain.getNoOfPersons()).thenReturn(4);
        when(mockTrain.getRates()).thenReturn(200);

        double result = fareCalculator.book(mockTrain);
        assertEquals(800, result, 0);
    }

}
