<template class="body">
  <div id="app">

    <div v-if="isEntering">
      <navigation :data="{comName,isEntering}"
      @changeComponent1Data="component1DataChange"></navigation>
    </div>

    <component :is="comName" :data="{comName,isEntering}"
      @changeComponent1Data="component1DataChange">
    </component>

  </div>
</template>

<script>
import './css/mainAppCss.css'
import Navigation from './components/Navigation'
import login from './components/login-register'
import FirstView from './components/FirstView'
import booking from './components/booking'
import bills from './components/bills'
import personal from './components/Personal'
import reporting from './components/reporting'
import sharing from './components/Sharing'

export default {
  name: 'App',
      data(){
        return{
          comName: 'login', // 当前 component 中的 :is 绑定的组件的名称
          isEntering:false,
          userName:''
      }},
  components:{
    "login":login,
    "navigation":Navigation,
    "firstView":FirstView,
    "booking":booking,
    "bills":bills,
    "personal":personal,
    "reporting":reporting,
    "sharing":sharing
  },
  methods:{
          component1DataChange(params1,params2) {
        this.comName = params1;
        this.isEntering=params2;
      }
  }
}

</script>

<style>

</style>
