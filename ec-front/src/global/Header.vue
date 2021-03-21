<template>
  <div>
    <span>EC-Sample</span>
    <span style="float: right">
      <span style="padding-right: 10px"> {{ date }} {{ time }} </span>
      <!-- ログイン後はユーザー名は表示されるようにする -->
      <span v-if="isLogin">こんにちは、{{loginName}}さん</span>
      <span v-if="!isLogin">こんにちは、ゲストさん</span>
    </span>
    <hr />
  </div>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
  name: "Header",
  data() {
    return {
      date: "",
      time: "",
    };
  },
  computed:{
    ...mapGetters({
      loginName:'auth/getUserName',
      isLogin:'auth/isLogin'
    })
  },
  mounted() {
    setInterval(this.updateTime, 1000);
  },
  methods: {
    updateTime() {
      const now = new Date();
      this.date =
        now.getFullYear() +
        "/" +
        String(now.getMonth() + 1).padStart(2, "0") +
        "/" +
        String(now.getDate()).padStart(2, "0");
      this.time =
        String(now.getHours()).padStart(2, "0") +
        ":" +
        String(now.getMinutes()).padStart(2, "0") +
        ":" +
        String(now.getSeconds()).padStart(2, "0");
    },
  },
};
</script>

<style scoped>
</style>