package com.examly.springapp.services;

import org.springframework.stereotype.Service;

@Service
public class Booking{
    //	Enter code here...
    public double booking(int noOfPersons, int rates){
        double totalRate;
        totalRate = noOfPersons * rates;
        return totalRate;
    }
}

