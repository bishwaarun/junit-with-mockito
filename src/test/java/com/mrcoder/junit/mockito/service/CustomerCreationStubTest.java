package com.mrcoder.junit.mockito.service;

import com.mrcoder.junit.mockito.dao.CustomerDao;
import com.mrcoder.junit.mockito.services.CustomerCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerCreationStubDao implements CustomerDao {
    @Override
    public int[] findCustomerDetails() {
        return new int[]{1,2,3};
    }
}

class CustomerCreationEmptyStubDao implements CustomerDao {
    @Override
    public int[] findCustomerDetails() {
        return new int[]{};
    }
}

class CustomerCreationOneValueStubDao implements CustomerDao {
    @Override
    public int[] findCustomerDetails() {
        return new int[]{5};
    }
}


public class CustomerCreationStubTest {

    @Test
    public void calculateSumUsingStub(){
        CustomerCreationService service = new CustomerCreationService();
        service.setCustomerDao(new CustomerCreationStubDao());
        int acutalValue=service.calculateSumUsingStub();
        Assertions.assertEquals(6,acutalValue);
    }

    @Test
    public void calculateSumUsingStub_Empty(){
        CustomerCreationService service = new CustomerCreationService();
        service.setCustomerDao(new CustomerCreationEmptyStubDao());
        int acutalValue=service.calculateSumUsingStub();
        Assertions.assertEquals(0,acutalValue);
    }

    @Test
    public void calculateSumUsingStub_OneValue(){
        CustomerCreationService service = new CustomerCreationService();
        service.setCustomerDao(new CustomerCreationOneValueStubDao());
        int acutalValue=service.calculateSumUsingStub();
        Assertions.assertEquals(5,acutalValue);
    }
}
