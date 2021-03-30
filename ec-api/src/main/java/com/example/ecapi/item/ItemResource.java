package com.example.ecapi.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResource {

    String itemCode;

    String categoryId;

    String itemName;

    String maker;

    String stockCount;

    String registerDate;

    String unitPrice;

    String pictureName;

    String memo;

    String deleteFlg;

    String lastUpdDate;
}
