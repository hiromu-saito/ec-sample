package com.example.ecdomain.service;

import com.example.ecapi.item.ItemQuery;
import com.example.ecapi.item.ItemResource;
import com.example.ecdomain.dao.ItemCategoryDao;
import com.example.ecdomain.dao.ItemDao;
import com.example.ecdomain.dto.Item;
import com.example.ecdomain.dto.ItemCategory;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    ItemCategoryDao itemCategoryDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ModelMapper modelMapper;

    public List<ItemResource> searchItem(ItemQuery query){
        val items =  itemDao.select(query);
        return  items
                .stream()
                .map(item -> modelMapper.map(item, ItemResource.class))
                .collect(Collectors.toList());
    }

    public List<ItemCategory> getCategory(){
        return  itemCategoryDao.select();
    }
}
