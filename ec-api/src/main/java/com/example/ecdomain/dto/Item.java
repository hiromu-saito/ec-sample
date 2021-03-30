package com.example.ecdomain.dto;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import java.sql.Date;
import java.sql.Timestamp;

@Table(name = "ONLINE_ITEM")
@Entity
@Getter
@Setter
//TODO TABLEの名前をPRODUCTからITEMに変える
public class Item {

    @Column(name = "PRODUCT_CODE")
    String itemCode;

    @Column(name = "CATEGORY_ID")
    int categoryId;

    @Column(name = "PRODUCT_NAME")
    String itemName;

    @Column(name = "MAKER")
    String maker;

    @Column(name = "STOCK_COUNT")
    String stockCount;

    @Column(name = "REGISTER_DATE")
    Date registerDate;

    @Column(name = "UNIT_PRICE")
    long unitPrice;

    @Column(name = "PICTURE_NAME")
    String pictureName;

    @Column(name = "MEMO")
    String memo;

    @Column(name = "DELETE_FLG")
    String deleteFlg;

    @Column(name = "LAST_UPD_DATE")
    Timestamp lastUpdDate;
}
