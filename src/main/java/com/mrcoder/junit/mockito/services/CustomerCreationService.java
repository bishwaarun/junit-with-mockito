package com.mrcoder.junit.mockito.services;

//import com.mrcoder.customer_creation_service.dao;

import com.mrcoder.junit.mockito.dao.CustomerDao;

public class CustomerCreationService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int calculateSumUsingStub(){
        int[] data = customerDao.findCustomerDetails();
        int sum=0;
        for(int value : data){
            sum+=value;
        }
        return sum;
    }

    public int calculateSum(int[] data){
        int sum=0;
        for(int value : data){
            sum+=value;
        }
        return sum;
    }
}
