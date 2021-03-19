package com.example.ecapi.member;

import lombok.Getter;
import lombok.Setter;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
public class MemberResource {

    Integer memNo;

    String password;

    String name;

    Integer age;

    String sex;

    String zip;

    String address;

    String tel;

    Date registerDate;

    String deleteFlg;

    Timestamp lastUpdDate;
}
