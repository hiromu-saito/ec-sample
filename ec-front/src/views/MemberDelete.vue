<template>
  <div>
    <div class="mem_info" v-if="!isDeleted">
    この情報を削除しますか？<br>
    〇会員情報
      <table>
        <tr>
          <th>氏名</th>
          <td>{{loginUser.name}}</td>
        </tr>
        <tr>
          <th>年齢</th>
          <td>{{loginUser.age}}</td>
        </tr>
        <tr>
          <th>性別</th>
          <td>{{decedeSex(loginUser.sex)}}</td>
        </tr>
        <tr>
          <th>郵便番号</th>
          <td>{{loginUser.zip}}</td>
        </tr>
        <tr>
          <th>住所1</th>
          <td>{{loginUser.address1}}</td>
        </tr>
        <tr>
          <th>住所2</th>
          <td>{{loginUser.address2}}</td>
        </tr>
        <tr>
          <th>電話番号</th>
          <td>{{loginUser.tel}}</td>
        </tr>
      </table>
      <p>
        <button @click="memberDelete">実行</button>
        <router-link tag="button" to="/member_info">戻る</router-link>
      </p>
    </div>
    <div v-if="isDeleted">
      <p>会員情報の削除が完了しました。</p>
      <router-link tag="button" to="/">メニューへ</router-link>
    </div>
  </div>
</template>

<script>
import store from '../store'

export default {
  name:'MemberDelete',
  data(){
    return{
      isDeleted:false
    }
  },
  methods:{
    memberDelete(){
      console.log('削除API呼び出し')
      this.isDeleted=true
  },
  decedeSex(sex){
    switch (sex){
      case  "M":
        return "男性"
      case "F":
        return "女性"
      case "O":
        return "その他"
    }
    return "その他"
  }
},
computed:{
  loginUser(){
    return store.getters['auth/getUser']
  }
}
}
</script>

<style>

</style>