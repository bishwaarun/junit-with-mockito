package com.mrcoder.junit.mockito.service;

import com.mrcoder.junit.mockito.dao.CustomerDao;
import com.mrcoder.junit.mockito.dao.ItemDao;
import com.mrcoder.junit.mockito.models.Item;
import com.mrcoder.junit.mockito.services.CustomerCreationService;
import com.mrcoder.junit.mockito.services.ItemBusinessService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService service;

    @Mock
    private ItemDao itemDao;

    @Test
    public void retrieveAllItems_Basic(){

        when(itemDao.findAll()).thenReturn(
                Arrays.asList(new Item(1,"Item1",10,20),
                        new Item(2,"Item2",11,21)
                )
        );
        List<Item> itemList = service.retrieveAllItems();
        Assertions.assertEquals(100,itemList.get(0).getValue());
        Assertions.assertEquals(121,itemList.get(1).getValue());
    }
}
