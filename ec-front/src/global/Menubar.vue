<template>
  <div>
    <nav>
      <ul>
        <li><router-link to="/">新規会員登録</router-link></li>
        <li><router-link to="/">会員情報変更・削除</router-link></li>
        <li><router-link to="/">商品検索</router-link></li>
        <li><router-link to="/">お買い物かご</router-link></li>
        <button class="logout">ログアウト</button>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: "Menubar",
};
</script>

<style scoped>
nav {
  text-align: center;
}
nav ul {
  margin: 0;
  padding: 0;
}
nav li {
  list-style: none;
  display: inline-block;
  width: 10%;
  min-width: 90px;
}
nav li:not(:last-child) {
  border-right: 2px solid #ddd;
}
nav a {
  text-decoration: none;
  color: #333;
}
nav a.current {
  color: #00b0f0;
  border-bottom: 2px solid #00b0f0;
}
nav a:hover {
  color: #f7cb4d;
  border-bottom: 2px solid #f7cb4d;
}
.logout {
  float: right;
}
</style>