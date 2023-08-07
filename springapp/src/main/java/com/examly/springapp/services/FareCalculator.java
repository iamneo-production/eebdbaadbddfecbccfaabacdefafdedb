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

    public double book(Flight flight) {

        double totalFare = booking(flight.getNoOfPersons(),flight.getRates());

        if(flight.getTriptype().equalsIgnoreCase("one-way")){
            return totalFare;
        }else{
            int comp = (flight.getFrom()).compareTo(flight.getTo());
            if(comp < 0)
                return 2 * totalFare;
            else
                return 0;
        }
    }

    public double book(Bus bus) {
        double totalFare = booking(bus.getNoOfPersons(),bus.getRates());
        return totalFare;
    }

    public double book(Hotel hotel) {
        double totalFare = 0;
        if(hotel.getFromdate().isBefore(hotel.getTodate())){
            totalFare = booking(hotel.getNoOfPersons(), hotel.getRates());
        }
        return totalFare;
    }

    public double book(Train train) {
        double totalFare = booking(train.getNoOfPersons(),train.getRates());
        return totalFare;
    }

}
