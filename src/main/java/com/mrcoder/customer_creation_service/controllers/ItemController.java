package com.mrcoder.customer_creation_service.controllers;

import com.mrcoder.customer_creation_service.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Tea");
    }
}
