<template>
  <div>
    〇会員情報
     <div class="mem_info">
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
          <router-link tag="button" to="/member_modify">修正</router-link>
          <router-link tag="button" to="/member_delete">削除</router-link>
          <router-link tag="button" to="/">戻る</router-link>
        </p>
     </div>
  </div>
</template>

<script>

import store from '../store'

export default {
  name:"MemberInfo",
  beforeRouteEnter(to,from,next){
    if(store.getters['auth/isLogin']){
      next()
    }else next({name:'Signup'})
  },
  methods:{
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

<style scoped>
.mem_info {
  margin-left: 32px;
}
.mem_info table,
.mem_info th,
.mem_info td {
  border-collapse:collapse;
  border: solid 1px ;
}
.mem_info th {
  width: 150px;
  background-color: pink;
  text-align: right;
}
.mem_info td {
  vertical-align: middle;
  width: 200px;
}

.mem_info button {
  margin-right: 10px;
}

</style>