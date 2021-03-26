<template>
  <div>
    <div v-if="!isInput" class="modify">
      会員情報を入力してください。<br>
      〇会員情報
      <validation-observer
        tag="form"
        v-slot="{invalid}">
      <table>
        <tr>
          <th>会員No</th>
          <td>{{user.memNo}}</td>
        </tr>
        <tr>
          <th>氏名</th>
          <td>
            <validation-input
              inputType="text"
              name="名前"
              rules="required|max:20"
              :value.sync="user.name"/>
          </td>
        </tr>
        <tr>
          <th>パスワード</th>
          <td>
            <validation-input
                inputType="password"
                name="パスワード"
                rules="max:8|numalpha|passmatch:確認用パスワード"
                vid="パスワード"
                :value.sync="user.password"
                />
          </td>
        </tr>
        <tr>
            <th>確認用パスワード</th>
            <td>
              <validation-input
                inputType="password"
                name="確認用パスワード"
                rules="max:8|numalpha|passmatch:パスワード"
                vid="確認用パスワード"
                :value.sync="user.confirmPass"
                />
            </td>
          </tr>
        <tr>
            <th>年齢</th>
            <td>
              <validation-input
                inputType="text"
                name="年齢"
                rules="required|numeric"
                :value.sync="user.age"
                />
            </td>
          </tr>
        <tr>
          <th>性別</th>
            <td>
              <input type="radio" v-model="user.sex" value="M"/>男性
              <input type="radio" v-model="user.sex" value="F"/>女性
              <input type="radio" v-model="user.sex" value="O"/>その他
            </td>
          </tr>
        <tr>
          <th>郵便番号</th>
          <td>
            <validation-input
                inputType="type"
                name="郵便番号"
                rules="required|postalCode"
                :value.sync="user.zip"/>
          </td>
        </tr>
        <tr>
            <th>住所1</th>
            <td>
              <validation-input
                inputType="text"
                name="住所1"
                rules="required"
                :value.sync="user.address1"
              />
            </td>
          </tr>
          <tr>
            <th>住所2</th>
            <td>
              <validation-input
                inputType="text"
                name="住所2"
                rules="required"
                :value.sync="user.address2"
              />
            </td>
          </tr>
          <tr>
            <th>電話番号</th>
            <td>
              <validation-input
                inputType="tel"
                name="電話番号"
                rules="required|max:20|tel"
                :value.sync="user.tel"
                />
            </td>
          </tr>
      </table>
      <p>
        <button @click.prevent="isInput = !isInput" :disabled="invalid">確認</button>
        <router-link tag="button" to="/member_info">戻る</router-link>
        <button @click.prevent="clear">クリア</button>
      </p>
      </validation-observer>
    </div>
    <div v-if="isInput && !isConfirmd" class="confirm">
      <p>
        この内容に変更しますか？<br>
        〇会員情報
      </p>
        <table>
          <tr>
            <th>氏名</th>
            <td>{{user.name}}</td>
          </tr>
          <tr>
            <th>年齢</th>
            <td>{{user.age}}</td>
          </tr>
          <tr>
            <th>性別</th>
            <td>{{decodeSex}}</td>
          </tr>
          <tr>
            <th>郵便番号</th>
            <td>{{user.zip}}</td>
          </tr>
          <tr>
            <th>住所1</th>
            <td>{{user.address1}}</td>
          </tr>
          <tr>
            <th>住所2</th>
            <td>{{user.address2}}</td>
          </tr>
          <tr>
            <th>電話番号</th>
            <td>{{user.tel}}</td>
          </tr>
        </table>
        <p>
          <button @click.prevent="update">登録</button>
          <button @click.prevent="isInput = !isInput">戻る</button>
        </p>
      </div>
      <div v-if="isConfirmd && isInput">
        会員情報の修正が完了しました。<br>
        <router-link tag="button" to="/">メニューへ</router-link>
      </div>
    </div>
</template>

<script>
import store from '../store'
const MODIFY_URL = "http://localhost:18081/user"

export default {
  name:"MemberModify",
  data(){
    return{
      user:{},
      isInput:false,
      isConfirmd:false
    }
  },
  mounted(){
    this.init()
  },
  methods:{
    init(){
      this.user = {...this.loginUser}
      this.user.password = ''
      this.user.age = String(this.user.age)
    },
    clear(){
      this.init()
      this.$children[0].reset()
    },
    async update(){
      await fetch(MODIFY_URL,{
        method:'PUT',
        headers: {
          'X-Requested-With': 'csrf',
          'Content-Type': 'application/json',
          },
        body:JSON.stringify(this.user)
      })
      this.$store.dispatch('auth/nameSaveAction', this.user);
      this.isConfirmd = true
      }
  },
  computed:{
    loginUser(){
      return store.getters['auth/getUser']
    },
    decodeSex(){
      switch (this.user.sex){
        case  "M":
          return "男性"
        case "F":
          return "女性"
        case "O":
          return "その他"
      }
      return "その他"
    }
  }
}
</script>

<style>
.modify {
  margin-left: 32px;
}
.modify table,
.modify th,
.modify td {
  border-collapse: collapse;
}
.modify th {
  width: 200px;
  background-color: pink;
  text-align: right;
}
.modify td {
  vertical-align: middle;

}

.modify button {
  margin-right: 10px;
}

.confirm {
  margin-left: 32px;
}
.confirm table,
.confirm th,
.confirm td {
  border-collapse:collapse;
  border: solid 1px ;
}
.confirm th {
  width: 150px;
  background-color: pink;
  text-align: right;
}
.confirm td {
  vertical-align: middle;
  width: 200px;
}
.confirm button {
  margin-right: 10px;
}
</style>