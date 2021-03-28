package com.example.ecdomain.service;

import com.example.ecapi.item.ItemResource;
import com.example.ecdomain.dao.ItemCategoryDao;
import com.example.ecdomain.dao.ItemDao;
import com.example.ecdomain.dto.Item;
import com.example.ecdomain.dto.ItemCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemCategoryDao itemCategoryDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ModelMapper modelMapper;

    public List<Item> searchItem(ItemResource resource){
        return  itemDao.select(modelMapper.map(resource,Item.class));
    }

    public List<ItemCategory> getCategory(){
        return  itemCategoryDao.select();
    }
}
