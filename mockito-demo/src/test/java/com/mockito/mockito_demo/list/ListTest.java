package com.mockito.mockito_demo.list;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

    @Test
    void simpleTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);

        assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2).thenReturn(3);

        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(3, listMock.size());
        // 여러 개를 설정하면 설정한 순서대로 반환하다가 마지막 값을 반복해서 반환
    }

    @Test
    void parameters() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("String");

        assertEquals("String", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    void genericParameters() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("String");

        assertEquals("String", listMock.get(0));
        assertEquals("String", listMock.get(1));
    }

}
