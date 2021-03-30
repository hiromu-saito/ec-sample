UPDATE ONLINE_MEMBER
SET
    /*%if member.password != ""*/
      PASSWORD = /*member.password*/'',                      -- パスワード
    /*%end*/
    NAME = /*member.name*/'' ,              -- 氏名
    AGE = /*member.age*/'' ,                              -- 年齢
    SEX = /*member.sex*/'' ,                            -- 性別
    ZIP = /*member.zip*/'' ,                           -- 郵便番号
    ADDRESS1 =  /*member.address1*/'' ,                    -- 住所
    ADDRESS2 = /*member.address2*/'' ,
    TEL = /*member.tel*/'' ,                              -- 電話番号
    LAST_UPD_DATE = current_timestamp           -- 最終更新日
WHERE
    `MEMBER_NO` = /*member.memNo*/''                    -- 会員番号


