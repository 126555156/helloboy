import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios';
import qs from 'qs';
Vue.use(Vuex)
const store = new Vuex.Store({
    // 定义状态
    state: {
        userInfo: "",
        islogin: 0,
        tabPaneName: "0",
        showAddFriends:false
    },
    mutations: {
        UP_USERINFO(state, data) {
            state.userInfo = data;
            sessionStorage.setItem('userInfo', JSON.stringify(data))
        },
        // UP_ISLOGIN(state, islogin) {
        //     state.islogin = islogin
        // },
        UP_TABPANE_NAME(state, tabPaneName) {
            state.tabPaneName = tabPaneName
        },
        IS_SHOW_ADDFRIENDS(state, boolean) {
            state.showAddFriends = boolean
        },
    },
    actions: {
        initialize(context, params) {
            axios.post("/initialize", qs.stringify(params))
            .then(function (response) {
                console.log("初始化验证", response);
                if (response.data.code == 0)
                context.commit("UP_USERINFO", response.data.data);
            })
            .catch(function (error) { 
                console.log("初始化失败")
            });
        },
        EXIT(context, params) {
            axios.post("/exit")
            .then(function (response) {
                console.log("退出登录", response);
                context.commit("UP_USERINFO","");
                sessionStorage.clear();
            })
            .catch(function (error) { 
                console.log("退出登录失败")
            });
        },
    },
    getters: {
        islogin: function (state) {
            if (state.userInfo.islogin) return state.userInfo.islogin;
            return 0;
        },
        showAddFriends: state => state.showAddFriends,
        userInfo: state => state.userInfo,
        tabPaneName: state => state.tabPaneName,
    }
})

export default store