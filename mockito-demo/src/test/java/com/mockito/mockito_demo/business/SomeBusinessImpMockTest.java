package com.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImpMockTest {

    @Mock
    private DataService dataService;

    @InjectMocks
    private SomeBusinessImpl business;

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15, 5});

        assertEquals(25, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_withOneValue() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {35});

        assertEquals(35, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {});

        assertEquals(Integer.MIN_VALUE, business.findTheGreatestFromAllData());
    }
}
