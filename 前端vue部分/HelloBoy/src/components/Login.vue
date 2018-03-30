<template>
  <div class="Login">
    <div class="Login-l">
      <h1 class="Login-title">欢迎来到HelloBoy</h1>
    </div>
    <div class="Login-r">
      <div class="login-main">
        <Tabs v-model="tabsName">
          <TabPane label="登录" icon="social-apple" name="0">
            <div class="login-content">
              <Form ref="loginForm" :model="loginForm">
                <FormItem prop="username">
                  <Input type="text" v-model="loginForm.username" placeholder="用户名">
                  <Icon type="ios-person-outline" slot="prepend"></Icon>
                  </Input>
                </FormItem>
                <FormItem prop="password">
                  <Input type="password" v-model="loginForm.password" placeholder="密码">
                  <Icon type="ios-locked-outline" slot="prepend"></Icon>
                  </Input>
                </FormItem>
                <FormItem>
                  <div style="text-align: left;">
                    <Checkbox v-model="isRemember" @on-change="changeRemember">记住密码</Checkbox>
                  </div>
                </FormItem>
                <FormItem>
                  <Button type="primary" @click="login()" long>登录</Button>
                </FormItem>
              </Form>
            </div>
          </TabPane>
          <TabPane label="注册" icon="social-windows" name="1">
            <div class="login-content">
              <Form ref="registerForm" :model="registerForm">
                <FormItem prop="nickname">
                  <Input type="text" v-model="registerForm.nickname" placeholder="昵称">
                  <Icon type="android-map" slot="prepend"></Icon>
                  </Input>
                </FormItem>
                <FormItem prop="username">
                  <Input type="text" v-model="registerForm.username" placeholder="用户名">
                  <Icon type="ios-person-outline" slot="prepend"></Icon>
                  </Input>
                </FormItem>
                <FormItem prop="password">
                  <Input :type="passwordType" v-model="registerForm.password" placeholder="密码">
                  <Icon type="ios-locked-outline" slot="prepend"></Icon>
                  </Input>
                </FormItem>
                <FormItem>
                  <div style="text-align: left;">
                    <Checkbox v-model="showPassword">显示密码</Checkbox>
                  </div>
                </FormItem>
                <FormItem>
                  <Button type="primary" @click="register()" long>注册</Button>
                </FormItem>
              </Form>
            </div>
          </TabPane>
        </Tabs>

      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapState } from "vuex";
import axios from "axios";
import qs from "qs";
export default {
  data() {
    return {
      showPassword: false,
      isRemember: false,
      loginForm: {
        username: "",
        password: ""
      },
      registerForm: {
        username: "",
        password: "",
        nickname: ""
      }
    };
  },
  computed: {
    ...mapGetters(["tabPaneName", "islogin"]),
    tabsName: {
      get: function() {
        return this.$store.state.tabPaneName;
      },
      // setter
      set: function(newValue) {
        this.$store.state.tabPaneName = newValue;
      }
    },
    passwordType() {
      if (this.showPassword) return "text";
      return "password";
    }
  },
  methods: {
    login() {
      var self = this;
      axios
        .post("/login", qs.stringify(this.loginForm))
        .then(function(response) {
          console.log("登录", response);
          var userInfo = response.data.data;
          if (response.data.code == 0) {
            self.$store.commit("UP_USERINFO", userInfo);
            self.$router.push("/");
            if (self.isRemember == true) {
              localStorage.setItem("username", userInfo.username);
              localStorage.setItem("password", userInfo.password);
              localStorage.setItem("isRemember", true);
            } else {
              localStorage.clear();
            }
          }
        })
        .catch(function(error) {});
    },
    register() {
      var self = this;
      axios
        .post("/register", qs.stringify(this.registerForm))
        .then(function(response) {
          console.log("注册", response);
          var userInfo = response.data.data;
          if (response.data.code == 0) {
            self.$store.commit("UP_USERINFO", response.data.data);
            self.$router.push("/");
            if (self.isRemember == true) {
              localStorage.setItem("username", userInfo.username);
              localStorage.setItem("password", userInfo.password);
              localStorage.setItem("isRemember", true);
            } else {
              localStorage.clear();
            }
          }
        })
        .catch(function(error) {});
    },
    changeRemember() {
      if (this.isRemember == true) {
        this.$Message.success(
          "记录密码功能不宜在公共场所(如网吧等)使用,以防密码泄露."
        );
      }
    }
  },
  watch: {
    // islogin(val) {
    //   if (val == 1) this.$router.push("/");
    // },
    // isRemember(val) {
    // }
  },
  created() {
    if (localStorage.isRemember == "true") {
      this.loginForm.username = localStorage.username;
      this.loginForm.password = localStorage.password;
      this.isRemember = true;
    }
  },
  mounted() {
    // if (this.islogin == 1) this.$router.push("/");
  }
};
</script>
<style lang="scss">
.Login {
  height: 100%;
  width: 100%;
  background: url(../assets/login.jpg);
  color: white;
}
.Login-title {
  font-size: 45px;
  margin-top: 300px;
}
.Login-l {
  width: calc(100% - 600px);
  height: 100%;
  float: left;
}
.Login-r {
  width: 600px;
  height: 100%;
  float: left;
}
.login-main {
  position: relative;
  margin: 150px 0 0 50px;
  width: 350px;
  background: rgba(0, 0, 0, 0.5);
  border-radius: 5px;
}
.login-l {
  width: 50%;
}
.login-content {
  padding: 50px 30px;
}

.Login .ivu-tabs-nav {
  width: 100%;
}
.Login .ivu-tabs-nav-container {
  font-size: 18px;
}
.Login .ivu-tabs {
  color: white;
}
.Login .ivu-tabs-nav .ivu-tabs-tab {
  width: 50%;
  padding: 15px 16px;
  //   height: 150px;
  // float: left;
  color: white;
}
</style>

