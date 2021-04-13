// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
// 引入路由
import VueRouter from 'vue-router'
// 引入路由的配置文件routes.js
import Routes from './routes'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Axios from 'axios'
import VueAxios from 'vue-axios'
import Qs from 'qs'
import vuescroll from "vuescroll";//引入vuescroll
import "vuescroll/dist/vuescroll.css";//引入vuescroll样式
Vue.use(vuescroll);//使用

Vue.use(VueAxios, Axios);
Vue.use(Qs);

Vue.config.productionTip = false
// 使用声明
Vue.use(ElementUI);
Vue.use(VueRouter);

// 创建路由
const router = new VueRouter({
	routes:Routes,
	// 消除地址栏中的“#”
	mode:"history"
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>',
  router:router
})
