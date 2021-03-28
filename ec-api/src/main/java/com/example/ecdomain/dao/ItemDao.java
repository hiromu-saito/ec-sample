package com.example.ecdomain.dao;

import com.example.ecdomain.dto.Item;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface ItemDao {

    @Select
    List<Item> select(Item item);
}
