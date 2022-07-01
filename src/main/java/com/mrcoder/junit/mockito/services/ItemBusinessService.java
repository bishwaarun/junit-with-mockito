package com.mrcoder.junit.mockito.services;

import com.mrcoder.junit.mockito.dao.ItemDao;
import com.mrcoder.junit.mockito.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemDao itemDao;

    public Item readHardCodedItem(){
        return new Item(1,"Tea");
    }

    public List<Item> retrieveAllItems(){
        List<Item> itemList = itemDao.findAll();
        for(Item item:itemList){
            item.setValue(item.getPrice()* item.getPrice());
        }
        return itemList;
    }

}
