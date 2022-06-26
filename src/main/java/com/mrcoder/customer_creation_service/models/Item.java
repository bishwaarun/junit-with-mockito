package com.mrcoder.customer_creation_service.models;

import lombok.Data;

@Data
public class Item {
    private int id;
    private String name;
    public Item(int id, String name) {
        this.id=id;
        this.name=name;
    }

}
