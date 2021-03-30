package com.example.ecapi.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class MemberResource {

    int memNo;

    String password;

    String name;

    Integer age;

    String sex;

    String zip;

    String address1;

    String address2;

    String tel;

}
