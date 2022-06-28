package com.mrcoder.junit.mockito.services;

import com.mrcoder.junit.mockito.models.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {
    public Item readHardCodedItem(){
        return new Item(1,"Tea");
    }
}
