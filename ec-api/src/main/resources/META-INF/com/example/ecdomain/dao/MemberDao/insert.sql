INSERT
INTO ONLINE_MEMBER(
     PASSWORD   ,                         -- パスワード
     NAME         ,                         -- 氏名
     AGE          ,                         -- 年齢
     SEX          ,                         -- 性別
     ZIP          ,                         -- 郵便番号
     ADDRESS      ,                         -- 住所
     TEL          ,                         -- 電話番号
     REGISTER_DATE,                         -- 登録日
     LAST_UPD_DATE                         -- 最終更新日
)
VALUES
(
    /*member.password*/'' ,                           -- パスワード
    /*member.name*/'' ,                           -- 氏名
    /*member.age*/'' ,                           -- 年齢
    /*member.sex*/'' ,                           -- 性別
    /*member.zip*/'' ,                           -- 郵便番号
    /*member.address*/'' ,                           -- 住所
    /*member.tel*/'' ,                           -- 電話番号
    current_timestamp,                           -- 登録日
    current_timestamp                           -- 最終更新日
)