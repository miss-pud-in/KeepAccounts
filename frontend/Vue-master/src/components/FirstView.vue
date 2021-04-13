<template>
  <div class="firstview">
    <svg width="0" height="0"> 
	    <filter id="filter">
		    <feTurbulence type="fractalNoise" baseFrequency=".01" numOctaves="6" />
		    <feDisplacementMap in="SourceGraphic" scale="100" />
	    </filter>
    </svg>
    <a href="#" @click="changeToBooking">
      <div class="left"  > 
        <div class="button _1"> 
          <h1>记 账 中 心</h1>
          <div class="back"></div>
        </div>
      </div>
    </a>
    <a href="#" @click="changeToBills">
      <div class="right" >
        <div class="button _2"> 
          <h1>账 本 中 心</h1>
          <div class="back"></div>
        </div>
      </div>  
    </a>  
    <a href="#" @click="changeToSharing">
      <div class="left2">
        <div class="button _3"> 
          <h1>分 享 中 心</h1>
          <div class="back"></div>
        </div>
      </div>    
    </a>
    <a href="#" @click="changeToReporting">
      <div class="right2" >
        <div class="button _4"> 
          <h1>收 支 报 告</h1>
          <div class="back"></div>
        </div>
      </div>
    </a>
      <a href="#" @click="changeToPersonal">
      <div class="center" >
        <div class="button2 _2" > 
          <h1>个人中心</h1>

        </div>
      </div>
    </a>
  </div>
</template>

<script>
export default{
    data(){
      return{
        username:sessionStorage.getItem("username"),
      }
    },
		props: {
      //接收父组件传来的值
      comName: String,
      inEntering:Boolean,
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
.left{
    background: #e0ece6;
    margin: 0;
    width: 500px;
    height: 300px;
    position: absolute;
    top:30px;
    left:250px;
    box-shadow: -2px -2px 8px rgba(143, 135, 135, 0.1)
}
.right{
    background: #fbedc9;
    width: 500px;
    height: 300px;
    position: absolute;
    top:30px;
    left:750px;
    box-shadow: 2px -2px 8px rgba(143, 135, 135, 0.1)
}
.left2{
    background: #f9e5da;
    width: 500px;
    height: 300px;
    position: absolute;
    top:330px;
    left:250px;
    box-shadow: -2px 2px 8px rgba(143, 135, 135, 0.1)
}
.right2{
    background: #d3ebec;
    width: 500px;
    height: 300px;
    position: absolute;
    top:330px;
    left:750px;
    box-shadow: 2px 2px 8px rgba(143, 135, 135, 0.1)
}
.center{
    background: rgb(253, 212, 219);
    width: 200px;
    height: 200px;
    position: absolute;
    top:230px;
    left:650px;
    border-radius:150px;
    z-index: 10;
}

:root {
  --height: 100px;
  --width: 200px;
}

.button {
  position: relative;
  width: 500px;
  height: 300px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  overflow: hidden;
  transition: all 0.3s cubic-bezier(0, 0.22, 0.3, 1);
  
}

.button2 {
  position: relative;
  width: 200px;
  height: 200px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  overflow: hidden;
  transition: all 0.3s cubic-bezier(0, 0.22, 0.3, 1);
  
}

.button h1 {
  z-index: 10;
  color: white;

}
.center h1 {
  z-index: 10;
  color: white;
  text-align: center;
}

.button .back {
  position: absolute;
  width: 0;
  height: 0;
  filter: url(#filter);
  border-radius: 50%;
  z-index: 5;
  transition: all 2.5s cubic-bezier(0.1, 0.22, 0.3, 1);
}
.button._1 .back {
  left: -50%;
  top: -50%;
  background: #bdd2b6;
}
.button._2 .back {
  right: -50%;
  top: -50%;
  background: #ffe5a7;
}
.button._3 .back {
  left: -50%;
  bottom: -50%;
  background: #FFD3B4;
}
.button._4 .back { 
  right: -50%;
  bottom: -50%;
  background: #8FD6E1;
}
.button:hover .back {
  width: 1000px;
  height: 600px;
}



</style>