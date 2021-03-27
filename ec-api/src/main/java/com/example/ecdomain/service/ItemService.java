package com.example.ecdomain.service;

import com.example.ecdomain.dao.ItemCategoryDao;
import com.example.ecdomain.dto.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemCategoryDao itemCategoryDao;

    public List<ItemCategory> getCategory(){
        return  itemCategoryDao.select();
    }
}
