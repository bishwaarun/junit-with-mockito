package com.mrcoder.customer_creation_service.service;

import com.mrcoder.customer_creation_service.dao.CustomerDao;
import com.mrcoder.customer_creation_service.services.CustomerCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerCreationTest {

    @Test
    public void calculateSum(){
        CustomerCreationService service = new CustomerCreationService();
        int acutalValue=service.calculateSum(new int[]{1,2,3});
        Assertions.assertEquals(6,acutalValue);
    }

    @Test
    public void calculateSum_Empty(){
        CustomerCreationService service = new CustomerCreationService();
        int acutalValue=service.calculateSum(new int[]{});
        Assertions.assertEquals(0,acutalValue);
    }

    @Test
    public void calculateSum_OneValue(){
        CustomerCreationService service = new CustomerCreationService();
        int acutalValue=service.calculateSum(new int[]{5});
        Assertions.assertEquals(5,acutalValue);
    }
}
