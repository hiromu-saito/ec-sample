package com.example.ecapi.item;

import com.example.ecdomain.service.ItemService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/category")
    public ResponseEntity<Object> getItemCategory(){
        val categoryList = itemService.getCategory();
        return new ResponseEntity<>(categoryList,new HttpHeaders(),200);
    }
}
