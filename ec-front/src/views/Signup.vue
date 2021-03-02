<template>
  <div>
    <h1>新規会員登録</h1>
    <div v-if="!isInput">
      <p>会員情報を入力してください</p>
      <div class="signup">
      <validation-observer
        tag="form"
        v-slot="{invalid}">
        <table>
          <tr>
            <th>氏名</th>
            <td>
              <validation-input
                inputType="text"
                name="名前"
                rules="required|max:20"
                placeholder="山田太郎"
                :value.sync="user.name"
                />
              </td>
          </tr>
          <tr>
            <th>パスワード</th>
            <td>
              <validation-input
                inputType="password"
                name="パスワード"
                rules="required|max:8|numalpha|passmatch:確認用パスワード"
                placeholder="パスワード"
                vid="パスワード"
                :value.sync="user.passward"
                />
            </td>
          </tr>
          <tr>
            <th>確認用パスワード</th>
            <td>
              <validation-input
                inputType="password"
                name="確認用パスワード"
                rules="required|max:8|numalpha|passmatch:パスワード"
                placeholder="確認用パスワード"
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
              <input type="radio" v-model="user.gender" value="M"/>男性
              <input type="radio" v-model="user.gender" value="F"/>女性
              <input type="radio" v-model="user.gender" value="O"/>その他
            </td>
          </tr>
          <tr>
            <th>郵便番号</th>
            <td>
              <validation-input
                inputType="type"
                name="郵便番号"
                rules="required|postalCode"
                placeholder="000-0000"
                :value.sync="user.postalCode"
              />
            </td>
          </tr>
          <tr>
            <th>住所1</th>
            <td>
              <validation-input
                inputType="text"
                name="住所1"
                rules="required"
                placeholder=""
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
                placeholder=""
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
                placeholder="000-0000-0000"
                :value.sync="user.tel"
                />
            </td>
          </tr>
        </table>
        <p>
          <button @click.prevent="isInput = !isInput" :disabled="invalid">確認</button>
          <router-link tag="button" to="/">戻る</router-link>
          <button @click="clear">クリア</button>
        </p>
      </validation-observer>
      </div>
    </div>
    <div v-if="isInput">
      <p>この内容で登録しますか？</p>
      <div class="confirm">
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
            <td>{{decodeGender}}</td>
          </tr>
          <tr>
            <th>郵便番号</th>
            <td>{{user.postalCode}}</td>
          </tr>
          <tr>
            <th>住所1</th>
            <td>{{user.postalCode}}</td>
          </tr>
          <tr>
            <th>住所2</th>
            <td>{{user.postalCode}}</td>
          </tr>
          <tr>
            <th>電話番号</th>
            <td>{{user.tel}}</td>
          </tr>
        </table>
        <p>
          <button @click.prevent="register">登録</button>
          <button @click.prevent="isInput = !isInput">戻る</button>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import ValidationInput from '../components/ValidationInput'
export default {
  name: "Signup",
  components:{
    ValidationInput
  },
  data() {
    return{
      user: {
        gender:"m"
      },
      isInput:false
    };
  },
  mounted(){
    this.isInput !== false
  },
  computed:{
    decodeGender(){
      switch (this.user.gender){
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
  methods: {
    clear() {
      this.user = {}
    },
    register(){
      console.log("登録APIを呼び出す")
      this.$router.push("/signup_success")
    }
  },
};
</script>

<style scoped>
.signup {
  margin-left: 32px;
}
.signup table,
.signup th,
.signup td {
  border-collapse: collapse;
}
.signup th {
  width: 200px;
  background-color: pink;
  text-align: right;
}
.signup td {
  vertical-align: middle;

}

.signup button {
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