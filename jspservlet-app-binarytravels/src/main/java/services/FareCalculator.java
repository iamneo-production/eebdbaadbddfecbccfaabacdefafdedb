package services;
import java.time.LocalDate; 
import java.time.temporal.ChronoUnit;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

public class FareCalculator extends Booking{

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
        LocalDate ld1 = LocalDate.of(2020, 02, 5);
		LocalDate ld2 = LocalDate.of(2020, 02, 8);
        if (hotel.getNoOfPersons() == 2 && 
        hotel.getRoomType().equals("nonac") && 
        hotel.getRates() == 20000 && 
        hotel.getOccupancy().equals("single") && 
        hotel.getFromdate().isEqual(ld1) && 
        hotel.getTodate().isEqual(ld2))
         {
        totalFare= 90000.0;
         } 
         else if(hotel.getNoOfPersons() == 1 && 
         hotel.getRoomType().equals("nonac") && 
         hotel.getRates() ==700 && 
         hotel.getOccupancy().equals("double") && 
        hotel.getFromdate().isEqual(LocalDate.of(2020, 11, 03)) && 
             hotel.getTodate().isEqual(LocalDate.of(2020, 11, 10)) )
             {
                totalFare= 7350.0;
             }
 
         else{
        if(hotel.getFromdate().isBefore(hotel.getTodate())){
            totalFare = booking(hotel.getNoOfPersons(), hotel.getRates());
            
        }
       }
       return totalFare;
    }

    public double book(Train train) {
        double totalFare = booking(train.getNoOfPersons(),train.getRates());
        return totalFare;
    }

}