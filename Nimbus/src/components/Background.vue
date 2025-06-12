<template>
  <transition name="" v-for="cloud in clouds" class="h-100%">
      <img :src="`/src/assets/background/cloud${rand(1, 6)}.png`" alt="" 
      :style="`animation-delay: -${rand(0, 150)};`"
      :class="`cloud scale${rand(0, 5)} duration${rand(0, 5)} start${rand(0, 5)} position${rand(0, 5)} absolute -z-1 mix-blend-overlay`">
  </transition>
  <img :src="`/src/assets/background/moon1.png`" alt="" class="absolute -z-1">
    <!-- <img :src="`/src/assets/background/rain1.png`" alt="" class="absolute -z-1"> -->
</template>
<script setup lang="ts">
import { ref } from 'vue';
import { useHourlyForecast } from '../composables/HoursData'

const hourlyForecast = useHourlyForecast()
const clouds = ref(hourlyForecast.value[0].values.cloudCover);

function rand(min: number | null, max: number) {
  let number = 0;

  if (min) {
    number = Math.floor(Math.random() * max) + min;
  } else {
    number = Math.floor(Math.random() * max)
  }

  return number;
}

</script>
<style scoped>
.cloud{
  animation-name: hover; 
  animation-iteration-count: infinite;
}
.position0{top: -5%;}
.position1{top: 0;}
.position2{top: 5%;}
.position3{top: 10%;}
.position4{top: 15%;}

.duration0{animation-duration: 90s;}
.duration1{animation-duration: 100s;}
.duration2{animation-duration: 110s;}
.duration3{animation-duration: 120s;}
.duration4{ animation-duration: 150s;}

.scale0{scale: 150%;}
.scale1{scale: 200%;}
.scale2{scale: 170%;}
.scale3{scale: 140%;}
.scale4{scale: 160%;}

.start0{animation-delay: 0s;}
.start1{animation-delay: -20s;}
.start2{animation-delay: -40s;}
.start3{animation-delay: -60s;}
.start4{animation-delay: -80s;}

@keyframes hover {
  0% {transform: translateX(-20%); opacity: 0%;}
  10% {opacity: 100%;}
  90% {opacity: 100%;}
  100% {transform: translateX(30%); opacity: 0%}
}
</style>