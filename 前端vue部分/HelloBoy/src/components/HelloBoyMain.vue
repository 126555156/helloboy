<template>
  <div class="HelloBoyMain">
    <div class="HelloBoyMain-header">
      <router-link to="/" exact>
        <div class="HelloBoyMain-logo"></div>
      </router-link>
      <router-link to="/" exact>
        <div class="HelloBoyMain-title">首页</div>
      </router-link>
      <router-link to="/AboutOurs" exact>
        <div class="HelloBoyMain-title">关于我们</div>
      </router-link>
      <router-link to="/ConnectionAuthor" exact>
        <div class="HelloBoyMain-title">联系程序猿</div>
      </router-link>
      <router-link to="/PixiTest" exact>
        <div class="HelloBoyMain-title">Pixi测试模块</div>
      </router-link>
      <div class="HelloBoyMain-login">
        <router-link to="/Login" exact>
          <Button type="error" v-if="islogin==0" @click="showTabs('0')">登录</Button>
        </router-link>
        <router-link to="/Login" exact>
          <Button type="info" v-if="islogin==0" @click="showTabs('1')">注册</Button>
        </router-link>
        <Button type="warning" v-if="islogin==1" @click="exit">退出</Button>
      </div>
      <Poptip placement="bottom" width="300" v-if="islogin==1" trigger="hover" style="text-align:center">
        <div class="nickname">{{userInfo.nickname}}</div>
        <div class="HelloBoyMain-lv">LV{{userInfo.level}}</div>
        <Avatar class="HelloBoyMain-img" src="https://i.loli.net/2017/08/21/599a521472424.jpg" />
        <div slot="title">
          <h3>个人信息</h3>
        </div>
        <div slot="content">
          <div class="content-div">
            <Icon type="person"></Icon>&nbsp&nbsp个人中心
          </div>
          <div class="content-div" @click="showAddFriends()">
            <Icon type="person-add"></Icon>&nbsp&nbsp添加好友
          </div>
          <div class="content-div">
            <Badge count="0">
              <Icon type="email"></Icon>
            </Badge>&nbsp&nbsp私信
          </div>
          <div class="content-div">
            <Icon type="gear-a"></Icon>&nbsp&nbsp设置
          </div>
        </div>
      </Poptip>
    </div>
    <div>
      <router-view></router-view>
    </div>
    <add-friends></add-friends>
  </div>
</template>
<script>
import { mapGetters, mapState } from "vuex";
import AddFriends from "./AddFriends"
export default {
  data() {
    return {};
  },
  computed: {
    ...mapGetters(["islogin", "userInfo"])
  },
  methods: {
    exit() {
      this.$store.dispatch("EXIT");
    },
    showTabs(name) {
      this.$store.commit("UP_TABPANE_NAME", name);
    },
    showAddFriends(){
      this.$store.commit("IS_SHOW_ADDFRIENDS", true);
    }
  },
  mounted() {
    // console.log("用户信息",this.userInfo)
  },
  components:{
AddFriends
  }
};
</script>
<style lang="scss">
.HelloBoyMain {
  height: 100%;
  width: 100%;
  overflow: auto;
}

.HelloBoyMain .HelloBoyMain-header {
  height: 80px;
  text-align: right;
}

.HelloBoyMain-logo {
  float: left;
  height: 100%;
  margin-left: 150px;
  width: 150px;
  background: url(../assets/2018logo.png);
  background-size: contain;
  background-repeat: no-repeat;
  background-position: top;
  cursor: pointer;
}
.HelloBoyMain-title {
  width: 100px;
  text-align: center;
  float: left;
  height: 80px;
  line-height: 80px;
  font-size: 15px;
  cursor: pointer;
  // font-weight: 500;
  // font-weight:700;
}
.HelloBoyMain-login {
  float: right;
  height: 80px;
  line-height: 80px;
  margin-right: 80px;
}
.HelloBoyMain .router-link-active {
  font-weight: 700;
  color: #000;
}
.HelloBoyMain-img {
  margin: 15px 20px 15px 0px;
  height: 50px !important;
  width: 50px !important;
  // background: url(../assets/2018logo.png);
  background-size: contain;
  border: 1.5px solid greenyellow;
  float: right;
  border-radius: 50% !important;
  cursor: pointer;
}
.HelloBoyMain .nickname {
  height: 80px;
  // width: 100px;
  margin: 0 15px;
  line-height: 80px;
  // text-align: left;
  float: right;
  font-weight: 700;
  cursor: pointer;
  font-size: 15px;
}
.HelloBoyMain-lv {
  height: 80px;
  // width: 40px;
  line-height: 80px;
  float: right;
  font-weight: 700;
  cursor: pointer;
  font-size: 19px;
  text-align: left;
  color: gold;
}
.HelloBoyMain .content-div{
  font-size: 13px;
text-align: left;
padding: 5px 0px 5px 100px;
  cursor: pointer;
border-radius: 10px;
}
.HelloBoyMain .content-div:hover{
  background: gold;
  color: #fff
}
</style>
