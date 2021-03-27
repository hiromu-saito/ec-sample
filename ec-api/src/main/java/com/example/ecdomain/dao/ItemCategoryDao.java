package com.example.ecdomain.dao;

import com.example.ecdomain.dto.ItemCategory;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface ItemCategoryDao {

    @Select
    List<ItemCategory> select();

}
