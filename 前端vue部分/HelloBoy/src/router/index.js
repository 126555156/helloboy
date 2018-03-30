import Vue from 'vue'
import Router from 'vue-router'
import HelloBoyMain from '@/components/HelloBoyMain'
import HelloBoyHome from '@/components/HelloBoyHome'
import Login from '@/components/Login'
import ErrorPage from '@/components/ErrorPage'
import AboutOurs from '@/components/AboutOurs'
import ConnectionAuthor from '@/components/ConnectionAuthor'
import PixiTest from '@/components/pixi/PixiTest'
import 'iview/dist/styles/iview.css';
import iView from 'iview';
Vue.use(iView);
Vue.use(Router)
export default new Router({
  routes: [
    
    {
      path: '/',
      // name: 'HelloBoyMain',
      component: HelloBoyMain,
      children: [{
        path: '/',
        name: 'HelloBoyHome',
        component: HelloBoyHome,
      },
      {
        path: '/AboutOurs',
        name: 'AboutOurs',
        component: AboutOurs
      },
      {
        path: '/ConnectionAuthor',
        name: 'ConnectionAuthor',
        component: ConnectionAuthor
      },
      {
        path: '/PixiTest',
        name: 'PixiTest',
        component: PixiTest
      }]
    },
    {
      path: '/ErrorPage',
      name: 'ErrorPage',
      component: ErrorPage
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
  ]
})
