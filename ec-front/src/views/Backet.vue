<template>
  <div>
    <h1>お買い物かご</h1>
    <div class="backet" v-if="!isChecking && !orderSuccess">
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
            :key="backetItem.itemCode">
            <td><input type="checkbox" @click="toggleRemoveItem(backetItem.itemCode)"/></td>
            <td>{{backetItem.itemCode}}</td>
            <td>{{backetItem.itemName}}</td>
            <td>{{backetItem.maker}}</td>
            <td>&yen;{{backetItem.unitPrice}}</td>
            <td>
              <input
                type="text"
                v-model="backetItem.count"
              />
                </td>
          </tr>
        </tbody>
      </table>
      <p>
        <button @click.prevent="removeItem">取り消し</button>
        <button @click="stopShopping">買い物をやめる</button>
        <button @click="check">注文する</button>
        <button @click="$router.push('/')">メニューへ</button>
      </p>
    </div>
    <div class="backet_checking" v-if="isChecking && !orderSuccess">
      〇商品一覧
      <table>
        <thead>
          <tr>
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
            :key="backetItem.itemCode">
            <td>{{backetItem.itemCode}}</td>
            <td>{{backetItem.itemName}}</td>
            <td>{{backetItem.maker}}</td>
            <td>&yen;{{backetItem.unitPrice}}</td>
            <td>{{backetItem.count}}</td>
          </tr>
        </tbody>
      </table>
      〇料金
      <table>
        <tr>
          <th>小計</th>
          <td>&yen;{{subtotal}}</td>
        </tr>
        <tr>
          <th>消費税</th>
          <td>&yen;{{tax}}</td>
        </tr>
        <tr>
          <th>合計金額</th>
          <td>&yen;{{total}}</td>
        </tr>
      </table>
      <p>
        <button @click="stopShopping">買い物をやめる</button>
        <button @click="order">注文する</button>
        <button @click="isChecking = false">戻る</button>
      </p>
    </div>
    <div v-if="orderSuccess">
      注文が完了しました。
      <br>
      <button @click="$router.push('/')">メニューへ戻る</button>
    </div>
  </div>
</template>


<script>
import store from '../store'
import {mapActions,mapGetters} from 'vuex'

const BACKET = store.state.backet

export default {
  name: "Backet",
  data(){
    return{
      isChecking:false,
      orderSuccess:false,
      backetItems:BACKET.backetItems,
      removeItemCodes:[]
    }
  },
  computed:{
    ...mapGetters({
      subtotal:'backet/subtotal',
      tax:'backet/tax',
      total:'backet/total'
    }),
  },
  methods:{
    ...mapActions('backet',['removeItemsAction','removeAllItemAction','updateBacketAction']),
    stopShopping(){
      this.removeAllItemAction()
      this.$router.push('/')
    },
    check(){
      //TODO 在庫確認
      this.updateBacketAction(this.backetItems)
      this.isChecking = true
    },
    order(){
      this.orderSuccess = true
    },
    removeItem(){
      console.log('removeItem')
      this.removeItemsAction(this.removeItemCodes)
    },
    toggleRemoveItem(toggleItemCode){
      const index = this.removeItemCodes.findIndex(removeItemCode =>{
        return removeItemCode === toggleItemCode
      })
      if(index === -1){
        this.removeItemCodes.push(toggleItemCode)
        }else{
        this.removeItemCodes.splice(index,1)
      }
    }
  },
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
.backet_checking {
  margin-left: 32px;
}
.backet_checking table,
.backet_checking th,
.backet_checking td {
  border-collapse: collapse;
  border: solid 1px #000;
}
.backet_checking th {
  background-color: pink;
  text-align: right;
}
.backet_checking td {
  vertical-align: middle;

}

.backet_checking  button {
  margin-right: 10px;
}
</style>