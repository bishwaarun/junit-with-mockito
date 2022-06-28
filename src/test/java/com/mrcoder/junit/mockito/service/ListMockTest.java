package com.mrcoder.junit.mockito.service;

//import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ListMockTest {

    List listMock = mock(List.class);

    @Test
    public void returnWithGenericParameters(){
        when(listMock.get(anyInt())).thenReturn("Arun");
        Assertions.assertEquals("Arun",listMock.get(0));
        Assertions.assertEquals("Arun",listMock.get(1));
    }

    @Test
    public void size_basic(){
        when(listMock.size()).thenReturn(5);
        Assertions.assertEquals(5,listMock.size());
    }

    @Test
    public void returnDifferentValue(){
        when(listMock.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5,listMock.size());
        Assertions.assertEquals(10,listMock.size());
    }

    @Test
    public void returnWithParameters(){
        when(listMock.get(0)).thenReturn("Arun");
        Assertions.assertEquals("Arun",listMock.get(0));
        Assertions.assertEquals(null,listMock.get(1));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5
    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // 3
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5
        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size()); // 5
    }

}
