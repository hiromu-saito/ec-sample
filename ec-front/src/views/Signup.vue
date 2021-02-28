<template>
  <div>
    <div v-if="!isInput">
      <h1>新規会員登録</h1>
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
                rules="required"
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
                rules="required"
                placeholder="パスワード"
                :value.sync="user.passward"
                />
            </td>
          </tr>
          <tr>
            <th>確認用パスワード</th>
            <td>
              <validation-input
                inputType="text"
                name="確認用パスワード"
                rules="required"
                placeholder="確認用パスワード"
                :value.sync="user.confirmPass"
                />
            </td>
          </tr>
          <tr>
            <th>年齢</th>
            <td>
              <validation-input
                inputType="text"
                name="age"
                rules=""
                placeholder="10"
                :value.sync="user.age"
                />
            </td>
          </tr>
          <tr>
            <th>性別</th>
            <td>
              <input type="radio" v-model="user.sex" value="m"/>男性
              <input type="radio" v-model="user.sex" value="f"/>女性
              <input type="radio" v-model="user.sex" value="o"/>その他
            </td>
          </tr>
          <tr>
            <th>郵便番号</th>
            <td>
              <validation-input
                inputType="type"
                name="郵便番号"
                rules=""
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
                name="住所"
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
                name="住所"
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
                name="tel"
                rules=""
                placeholder="000-0000-0000"
                :value.sync="user.tel"
                />
            </td>
          </tr>
        </table>
        <p>
          <button @click.prevent="confirm" :disabled="invalid">確認</button>
          <router-link tag="button" to="/">戻る</router-link>
          <button @click="clear">クリア</button>
        </p>
      </validation-observer>
      </div>
    </div>
    <div v-if="isInput">
      <h1>確認画面表示</h1>
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
      user: {},
      isInput:false
    };
  },
  mounted(){
    this.isInput = false
  },
  methods: {
    clear() {
      this.user = {}
      console.log("入力値クリア");
    },
    confirm() {
      console.log(this.user);
      this.isInput = true
    },
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
</style>