// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './vuex/store'
import axios from 'axios'
Vue.config.productionTip = false
if(process.env.NODE_ENV=="development"){
  axios.defaults.baseURL = 'http://localhost:8080/HelloBoy';
}else{
  axios.defaults.baseURL = 'http:///huangweixiong.xyz:8080/HelloBoy';
}
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.withCredentials = true;

Vue.prototype.$axios = axios;
console.log("测试", process.env.NODE_ENV)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
