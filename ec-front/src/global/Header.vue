<template>
  <div>
    <span>EC-Sample</span>
    <span style="float: right">
      <span style="padding-right: 10px"> {{ date }} {{ time }} </span>
      <!-- ログイン後はユーザー名は表示されるようにする -->
      こんにちは，ゲストさん</span
    >
    <hr />
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      date: "",
      time: "",
    };
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