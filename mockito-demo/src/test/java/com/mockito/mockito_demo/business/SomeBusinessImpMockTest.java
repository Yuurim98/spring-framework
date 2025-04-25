package com.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class SomeBusinessImpMockTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataService dataService = mock(DataService.class);
        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15, 5});

        SomeBusinessImpl business = new SomeBusinessImpl(dataService);

        assertEquals(25, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_withOneValue() {
        DataService dataService = mock(DataService.class);
        when(dataService.retrieveAllData()).thenReturn(new int[] {35});

        SomeBusinessImpl business = new SomeBusinessImpl(dataService);

        assertEquals(35, business.findTheGreatestFromAllData());
    }
}
