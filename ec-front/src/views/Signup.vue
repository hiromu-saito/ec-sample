<template>
  <div>
    <h1>新規会員登録</h1>
    <p>会員情報を入力してください</p>
    <div class="signup">
      <table>
        <tr>
          <th>氏名</th>
          <td><input type="text" name="name" v-model="user.Name" /></td>
        </tr>
        <tr>
          <th>パスワード</th>
          <td><input type="password" name="pass" v-model="user.Password" /></td>
        </tr>
        <tr>
          <th>確認用パスワード</th>
          <td><input type="password" name="confirm_pass" /></td>
        </tr>
        <tr>
          <th>年齢</th>
          <td><input /></td>
        </tr>
        <tr>
          <th>性別</th>
          <td>
            <input type="radio" />男性 <input type="radio" />女性
            <input type="radio" />その他
          </td>
        </tr>
        <tr>
          <th>郵便番号</th>
          <td><input /></td>
        </tr>
        <tr>
          <th>住所1</th>
          <td><input /></td>
        </tr>
        <tr>
          <th>住所2</th>
          <td><input /></td>
        </tr>
        <tr>
          <th>電話番号</th>
          <td><input /></td>
        </tr>
      </table>
      <p>
        <button @click="confirm">確認</button>
        <!-- <button>戻る</button> -->
        <router-link tag="button" to="/">戻る</router-link>
        <button @click="clear">クリア</button>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Signup",
  data() {
    return {
      user: {},
    };
  },
  methods: {
    clear() {
      console.log("入力値クリア");
    },
    confirm() {
      console.log(this.user);
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
  border: 1px solid #000;
  border-collapse: collapse;
}
.signup th {
  width: 200px;
  background-color: pink;
  text-align: right;
}
.signup td {
  width: 300px;
}
.signup input {
  margin-left: 8px;
}
.signup button {
  margin-right: 10px;
}
</style>