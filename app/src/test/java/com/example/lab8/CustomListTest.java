package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * Creates a mock list for testing
     * @return a new CustomList instance with an empty city list
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * Test for addCity method: Adds a city to the list and checks if the list size increases by one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * Test for deleteCity method: Adds a city, then deletes it and checks if the size decreases.
     * Also checks that an exception is thrown when attempting to delete a non-existent city.
     */
    @Test
    public void deleteCityTest() throws Exception {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);


        int listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.getCount(), listSize - 1);


        Exception exception = assertThrows(Exception.class, () -> {
            list.deleteCity(city);
        });
        assertEquals("City not found: " + city.getCityName(), exception.getMessage());
    }

    /**
     * Test for hasCity method: Checks if a city exists in the list after adding it,
     * and verifies it returns false for a city not in the list.
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");

        // Initially should not contain city
        assertFalse(list.hasCity(city));

        // After adding, should contain city
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * Test for countCity method: Checks if countCity returns the correct number of cities.
     */
    @Test
    public void countCityTest() {
        list = MockCityList();


        assertEquals(0, list.countCity());


        list.addCity(new City("Estevan", "SK"));
        assertEquals(1, list.countCity());


        list.addCity(new City("Regina", "SK"));
        assertEquals(2, list.countCity());
    }
}
