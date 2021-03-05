<template>
  <div>
    <h1>お買い物かご</h1>
    <div class="backet">
      <table>
        <thead>
          <tr>
            <th>選択</th>
            <th>商品コード</th>
            <th>商品名</th>
            <th>販売元</th>
            <th>価格</th>
            <th>購入数</th>
          </tr>
        </thead>
        <tbody>
          <tr 
            v-for="backetItem in backetItems"
            :key="backetItem.code">
            <td><input type="checkbox"/></td>
            <td>{{backetItem.code}}</td>
            <td>{{backetItem.name}}</td>
            <td>{{backetItem.distributor}}</td>
            <td>{{backetItem.price}}</td>
            <td>{{backetItem.count}}</td>
          </tr>
        </tbody>
      </table>
      <p>
        <button>取り消し</button>
        <button>買い物をやめる</button>
        <button>注文する</button>
        <button @click="$router.push('/')">メニューへ</button>
      </p>
    </div>
  </div>
</template>


<script>
import store from '../store'

export default {
  name: "Backet",
  computed:{
    backetItems:()=> store.state.backet.backetItems
  }
};
</script>

<style scoped>
.backet {
  margin-left: 32px;
}
.backet table,
.backet th,
.backet td {
  border-collapse: collapse;
  border: solid 1px #000;
}
.backet th {
  background-color: pink;
  text-align: right;
}
.backet td {
  vertical-align: middle;

}

.backet button {
  margin-right: 10px;
}
</style>