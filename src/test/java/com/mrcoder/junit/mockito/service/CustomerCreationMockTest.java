package com.mrcoder.junit.mockito.service;

import com.mrcoder.junit.mockito.dao.CustomerDao;
import com.mrcoder.junit.mockito.services.CustomerCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerCreationMockTest {

    @InjectMocks
    private CustomerCreationService service;

    @Mock
    private  CustomerDao customerDao;

    @Test
    public void calculateSumUsingMock(){
        when(customerDao.findCustomerDetails()).thenReturn(new int[]{1,2,3});
        Assertions.assertEquals(6,service.calculateSumUsingStub());
    }

    @Test
    public void calculateSumUsingMock_Empty(){
        when(customerDao.findCustomerDetails()).thenReturn(new int[]{0});
        Assertions.assertEquals(0,service.calculateSumUsingStub());
    }

    @Test
    public void calculateSumUsingMock_OneValue(){
        when(customerDao.findCustomerDetails()).thenReturn(new int[]{5});
        Assertions.assertEquals(5,service.calculateSumUsingStub());
    }
}
