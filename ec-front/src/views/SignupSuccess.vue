<template>
  <div class="signup_success">
    <p>会員登録が完了しました。</p>
    <p>
      あなたの会員番号は<span style="font-weight:bold">{{$route.params.id}}</span>です
    </p>
    <button @click="$router.push('/')">メニューへ</button>
  </div>
</template>

<script>
export default {
  name:'SignupSuccess'
}
</script>
<style scoped>
.signup_success {
  text-align: center;
  margin-top: 60px;
}
</style>