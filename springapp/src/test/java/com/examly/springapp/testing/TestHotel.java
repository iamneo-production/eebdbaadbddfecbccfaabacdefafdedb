package com.examly.springapp.testing;

import com.examly.springapp.model.Hotel;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@ExtendWith(SpringExtension.class) 
@AutoConfigureMockMVC
@SpringBootTest(webEnvironment = SpringBootTest.webEnvironment.MOCK)
@TestMethodOrder(TestMethodOrderer.OrderAnnotation.class)
public class TestHotel {

    @Autowired
    private Hotel hotel;
    LocalDate ld1 = LocalDate.of(2020, 02, 03);
    LocalDate ld2 = LocalDate.of(2020, 02, 07);
    Hotel hotel1 = new Hotel(2, "nonac", 20000, "single", ld1, ld2);

    @Test
    public void testGetNoOfPersonMethod() {
        hotel1.setNoOfPersons(5);
        assertEquals(5, hotel1.getNoOfPersons());
        hotel1.setNoOfPersons(1);
        assertEquals(1, hotel1.getNoOfPersons());
        try {
            hotel1.setNoOfPersons(0);
            hotel1.setNoOfPersons(-5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRateMethod() {
        hotel1.setRates(12000);
        assertEquals(12000, hotel1.getRates());
        hotel1.setRates(8000);
        assertEquals(8000, hotel1.getRates());
        try {
            hotel1.setRates(0);
            hotel1.setRates(-500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRoomType() {
        hotel1.setRoomType("ac");
        assertEquals("ac", hotel1.getRoomType());
        try {
            hotel1.setRoomType(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetDate() {
        try {
            hotel1.setFromdate(null);
            hotel1.setTodate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

