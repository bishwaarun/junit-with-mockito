package com.mrcoder.junit.mockito.dao;

import com.mrcoder.junit.mockito.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item,Integer> {
}
