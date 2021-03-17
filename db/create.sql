CREATE TABLE ONLINE_MEMBER(
  MEMBER_NO INT NOT NULL PRIMARY KEY COMMENT '会員番号',
  PASSWORD VARCHAR (8) NOT NULL COMMENT 'パスワード',
  NAME VARCHAR (20) NOT NULL COMMENT '氏名',
  AGE INT NOT NULL COMMENT '年齢',
  SEX CHAR(1) NOT NULL COMMENT '性別:M:男性、F:女性',
  ZIP VARCHAR (8) NOT NULL COMMENT '郵便番号',
  ADDRESS VARCHAR (50) NOT NULL COMMENT '住所',
  TEL VARCHAR (29) NOT NULL COMMENT '電話番号',
  REGISTER_DATE DATE NOT NULL COMMENT '登録日',
  DELETE_FLG CHAR(1) DEFAULT 0 NOT NULL COMMENT '削除フラグ:0:有効,1:無効',
  LAST_UPD_DATE TIMESTAMP COMMENT '最終更新日'
);
CREATE TABLE ONLINE_CATEGORY(
  CTGR_ID INT NOT NULL PRIMARY KEY COMMENT 'カテゴリID',
  NAME VARCHAR(20) NOT NULL COMMENT 'カテゴリ名',
  LAST_UPD_DATE TIMESTAMP COMMENT '最終更新日'
);
CREATE TABLE ONLINE_STAFF(
  STAFF_NO INT NOT NULL PRIMARY KEY NOT NULL COMMENT '管理者番号',
  PASSWORD VARCHAR (8) NOT NULL COMMENT 'パスワード',
  NAME VARCHAR (20) NOT NULL COMMENT '氏名',
  AGE INTEGER NOT NULL COMMENT '年齢',
  SEX CHAR (1) NOT NULL COMMENT '性別:M:男性、F:女性',
  REGISTER_DATE DATE NOT NULL COMMENT '登録日',
  LAST_UPD_DATE TIMESTAMP COMMENT '最終更新日'
);
CREATE TABLE ONLINE_PRODUCT(
  PRODUCT_CODE VARCHAR (14) PRIMARY KEY NOT NULL COMMENT '商品コード',
  CATEGORY_ID INTEGER NOT NULL COMMENT 'カテゴリID',
  PRODUCT_NAME VARCHAR (50) NOT NULL COMMENT '商品名',
  MAKER VARCHAR (20) NOT NULL COMMENT '販売元',
  STOCK_COUNT INTEGER NOT NULL COMMENT '在庫数量',
  REGISTER_DATE DATE NOT NULL COMMENT '登録日',
  UNIT_PRICE BIGINT NOT NULL COMMENT '金額（単価）',
  PICTURE_NAME VARCHAR (100) COMMENT '写真ファイル名',
  MEMO VARCHAR (255) COMMENT 'メモ',
  DELETE_FLG CHAR (1) DEFAULT 0 NOT NULL COMMENT '削除フラグ:0：取扱い中、1：取扱い終了',
  LAST_UPD_DATE TIMESTAMP COMMENT '最終更新日',
  CONSTRAINT CATEGORY_ID_FK FOREIGN KEY (CATEGORY_ID) REFERENCES ONLINE_CATEGORY (CTGR_ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE TABLE ONLINE_ORDER(
  ORDER_NO INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '商品コード',
  MEMBER_NO INT NOT NULL COMMENT '会員番号',
  TOTAL_MONEY BIGINT NOT NULL COMMENT '注文トータル金額',
  TOTAL_TAX BIGINT NOT NULL COMMENT '注文トータル消費税金額',
  ORDER_DATE DATE NOT NULL COMMENT '注文日',
  COLLECT_NO VARCHAR(16) NOT NULL UNIQUE COMMENT '注文とりまとめ番号',
  LAST_UPD_DATE TIMESTAMP NOT NULL COMMENT '最終更新日',
  CONSTRAINT MEMBER_NO_FK FOREIGN KEY (MEMBER_NO) REFERENCES ONLINE_MEMBER (MEMBER_NO) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE TABLE ONLINE_ORDER_LIST(
  LIST_NO INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '明細番号',
  COLLECT_NO VARCHAR (16) NOT NULL COMMENT '注文とりまとめ番号',
  PRODUCT_CODE VARCHAR (14) NOT NULL COMMENT '商品コード',
  ORDER_COUNT INT NOT NULL COMMENT '数量',
  ORDER_PRICE BIGINT NOT NULL COMMENT '金額（単価）'
);