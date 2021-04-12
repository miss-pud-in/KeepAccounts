<template>
  <div class="card-holder">
    <div class="card-wrapper">
      <a href="#" @click="changeToBooking">
        <div class="card bg-01">
          <span class="card-content">记账中心</span>
        </div>
      </a>
    </div>
    <div class="card-wrapper">
      <a href="#" @click="changeToBills">
        <div class="card bg-02">
          <span class="card-content">账单中心</span>
        </div>
      </a>
    </div>
    <div class="card-wrapper">
      <a href="#" @click="changeToSharing">
        <div class="card bg-03">
          <span class="card-content">分享中心</span>
        </div>
      </a>
    </div>
    <div class="card-wrapper">
      <a href="#" @click="changeToReporting">
        <div class="card bg-04">
          <span class="card-content">收支报告</span>
        </div>
      </a>
    </div>
        <div class="card-wrapper">
      <a href="#" @click="changeToPersonal">
        <div class="card bg-03">
          <span class="card-content">个人中心
          </span>
        </div>
      </a>
    </div>
  </div>
</template>

<script>
export default{
    name: 'Navigation',
		props: {
      //接收父组件传来的值
      comName: String,
      inEntering:Boolean
    },
    methods:{
      changeToBooking(){
        this.$emit("changeComponent1Data", "booking",true);
      },
      changeToBills(){
        this.$emit("changeComponent1Data", "bills",true);
      },
      changeToSharing(){
        this.$emit("changeComponent1Data", "sharing",true);
      },
      changeToPersonal(){
        this.$emit("changeComponent1Data", "personal",true);
      },
      changeToReporting(){
        this.$emit("changeComponent1Data", "reporting",true);
      }
    }
}
</script>

<style scoped>

a:link,
a:hover,
a:visited,
a:active {
  color: #fff;
  text-decoration: none;
}

body {
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;

  background: #fff;
}

.card-holder {
  position: fixed;
  width: 0px;
  overflow: visible;
}

.card-wrapper {
  display: inline-block;
  float: right;
  text-align: left;
  clear: both;
}

.card {
  position: relative;
  left: 50px;
  top:80px;
  padding: 16px 32px 16px 64px;
  margin: 16px;
  width: 140px;
  height: 35px;
  x-box-shadow: 0 0 8px 0px rgba(0, 0, 0, 0.5);
  box-shadow: 8px 0 8px -8px rgba(0, 0, 0, 0.5);
  background: #fff;
  transition: all 0.3s ease-in-out 0.1s;
}

.card:hover {
  position: relative;
  left: 100%;
  margin-left: -32px;
  box-shadow:
    0 -8px 8px -8px rgba(0, 0, 0, 0.5),
    0 8px 8px -8px rgba(0, 0, 0, 0.5);
  transition: all 0.3s ease-in-out;
}

.card-content {
  display: inline-block;
  color: #fff;
  font-family: 'Droid Sans', sans-serif;
  font-size: 25px;
  font-weight: bold;
  white-space: nowrap;
}

.bg-01 { background: #FCD1D1}
.bg-02 { background: #ECE2E1}
.bg-03 { background: #D3E0DC; }
.bg-04 { background: #fff2ef; }

</style>
