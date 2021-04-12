<template>
<div>
  <div class="button _1"> <span>hover</span>
    <div class="back"></div>
  </div>
  <div class="button _2"> <span>hover</span>
    <div class="back"></div>
  </div>
  <div class="button _3"> <span>hover</span>
    <div class="back"></div>
  </div>
  <div class="button _4"> <span>hover</span>
    <div class="back"></div>
  </div>
</div>
</template>

<script>
import Navigation from './Navigation.vue'
export default {
  components: { Navigation },
}
</script>

<style scoped>
:root {
  --height: 100px;
  --width: 200px;
}


.wrapper {
  width: calc(4 * var(--width));
  height: calc(4 * var(--height));
  display: flex;
  justify-content: center;
  align-items: center;
}

.button {
  position: relative;
  width: calc(0.8 * var(--width));
  height: calc(0.7 * var(--height));
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  overflow: hidden;
  margin: 0 0.8rem;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2), 0 3px 8px rgba(0, 0, 0, 0.1);
  transition: all 0.3s cubic-bezier(0, 0.22, 0.3, 1);
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
  background: #27ae60;
}
.button._2 .back {
  right: -50%;
  top: -50%;
  background: #c0392b;
}
.button._3 .back {
  left: -50%;
  bottom: -50%;
  background: #34495e;
}
.button._4 .back {
  right: -50%;
  bottom: -50%;
  background: #2980b9;
}
.button:hover .back {
  width: calc(2 * var(--width));
  height: calc(2 * var(--height));
}





</style>