package com.example.ecdomain.dto;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;
import java.sql.Time;

@Table(name ="ONLINE_MEMBER")
@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "MEMBER_NO")
    Integer memNo;

    @Column(name = "PASSWORD")
    String password;

    @Column(name = "NAME")
    String name;

    @Column(name = "AGE")
    Integer age;

    @Column(name = "SEX")
    String sex;

    @Column(name = "ZIP")
    String zip;

    @Column(name = "ADDRESS")
    String address;

    @Column(name = "TEL")
    String tel;

    @Column(name = "REGISTER_DATE")
    String registerDate;

    @Column(name = "DELETE_FLG")
    String deleteFlg;

    @Column(name = "LAST_UPD_DATE")
    Time lastUpdDate;
}
