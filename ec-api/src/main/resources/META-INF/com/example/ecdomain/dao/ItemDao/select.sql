SELECT
  /*%expand*/*
FROM
  ONLINE_PRODUCT
WHERE
    DELETE_FLG = '0'
   /*%if @isNotEmpty(query.categoryId) */
    AND CATEGORY_ID = /* query.categoryId */''
   /*%end*/

  /*%if @isNotEmpty(query.name) */
    AND PRODUCT_NAME LIKE /* @infix(query.name) */''
  /*%end*/

  /*%if @isNotEmpty(query.maker) */
   AND MAKER LIKE /* @infix(query.maker) */''
  /*%end*/

  /*%if @isNotEmpty(query.minPrice) */
   AND UNIT_PRICE >= /* query.minPrice */''
  /*%end*/

  /*%if @isNotEmpty(query.maxPrice) */
   AND UNIT_PRICE <= /* query.maxPrice */''
  /*%end*/