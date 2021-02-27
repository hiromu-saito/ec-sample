<template>
  <div id="app">
    <Header />
    <Menubar />
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
