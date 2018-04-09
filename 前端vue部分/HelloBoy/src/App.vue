<template>
  <div id="app">
    <router-view/>
  </div>
</template>
<script>
import axios from "axios";
import qs from "qs";
export default {
  name: "App",
  data() {
    return {};
  },
  methods: {
    getSessionStorage() {
      if (sessionStorage.userInfo) {
        var userInfo = JSON.parse(sessionStorage.userInfo);
          this.$store.dispatch("initialize", {
            username: userInfo.username,
            password: userInfo.password
          });
      }else{
          this.$store.dispatch("initialize", {
            username: '',
            password: ''
          });
      }
    }
  },
  created() {
    // this.getSessionStorage();
  },
  mounted() {
    var self = this;
    axios.interceptors.response.use(
      function(response) {
        if (response.data.code == 0) {
          self.$Message.success(response.data.message);
        } else if (response.data.code == 1) {
          self.$Message.error(response.data.message);
        }
        return response;
      },
      function(err) {
        self.$Message.error("网络连接有误");
        console.log(err);
        return err;
      }
    );
  }
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
}
#app {
  min-width: 1000px;
  position: absolute;
  height: 100%;
  width: 100%;
  overflow: auto;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
a {
  color: #000;
}
</style>
