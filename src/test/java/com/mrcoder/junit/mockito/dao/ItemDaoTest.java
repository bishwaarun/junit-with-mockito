package com.mrcoder.junit.mockito.dao;

import com.mrcoder.junit.mockito.models.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ItemDaoTest {

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testFindAll(){
        List<Item> items = itemDao.findAll();
        Assertions.assertEquals(4,items.size());
    }
}
