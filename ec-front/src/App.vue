<template>
  <div id="app">
    <Header />
    <Menubar />
    <div><router-link to="/">Home</router-link></div>
    <router-view />
  </div>
</template>
<script>
import Header from "@/global/Header";
import Menubar from "@/global/Menubar";
export default {
  name: "App",
  components: {
    Header,
    Menubar,
  },
};
</script>
<style>
