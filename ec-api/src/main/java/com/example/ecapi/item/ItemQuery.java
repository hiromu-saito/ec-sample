package com.example.ecapi.item;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Getter
@Setter
@Table(name = "ONLINE_PRODUCT")
public class ItemQuery {

    String categoryId;

    String name;

    String maker;

    String maxPrice;

    String minPrice;
}
