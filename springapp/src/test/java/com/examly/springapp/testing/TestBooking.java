package com.examly.springapp.testing;

import static org.junit.Assert.*;

import com.examly.springapp.services.Booking;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
@ExtendWith(SpringExtension.class) 
@SpringBootTest
public class TestBooking {

    @Autowired
    private Booking book;

    @Test
    public void testBookingMethod() {
        assertEquals(6000, book.booking(2, 3000),0);
        assertEquals(1000, book.booking(1, 1000),0);
        try {
            book.booking(0, 5000);
            book.booking(5, 0);
            book.booking(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


