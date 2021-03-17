SELECT
  /*%expand*/*
FROM
  ONLINE_MEMBER
WHERE
  MEMBER_NO = /* memNo */1
    AND DELETE_FLG = '0'
