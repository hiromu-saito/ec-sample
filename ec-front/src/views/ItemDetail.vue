<template>
  <div>
    商品詳細
    <div class="detail">
      商品コード{{$route.params.id}}の商品詳細ページ
    </div>
    <button>お買いものかごに入れる</button>
    <router-link tag="button" to="/search">戻る</router-link>
  </div>
</template>

<script>
export default {
  name:"ItemDetail"
}
</script>

<style>
.detail{
  border: 1px solid ;
  width: 600px;
  height: 600px;
  background-color: skyblue;
}
</style>