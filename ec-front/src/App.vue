<template>
  <div id="app">
    <Header></Header>
    <hr />
    <div><router-link to="/">Home</router-link></div>
    <router-view />
  </div>
</template>
<script>
import Header from "@/global/Header";
export default {
  name: "App",
  components: {
    Header,
  },
};
</script>
<style>
