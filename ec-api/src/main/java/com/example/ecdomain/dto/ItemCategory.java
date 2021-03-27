package com.example.ecdomain.dto;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import java.sql.Timestamp;

@Table(name = "ONLINE_CATEGORY")
@Getter
@Setter
@Entity
public class ItemCategory {

    @Column(name = "CTGR_ID")
    int ctgrId;

    @Column(name = "NAME")
    String name;

    @Column(name = "LAST_UPD_DATE")
    Timestamp lastUpdDate;


}
