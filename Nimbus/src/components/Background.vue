<template>
  <transition-group name="fade" tag="div" v-if="isDay">
    <img v-for="cloud in clouds" :key="'day-' + cloud" :src="`/src/assets/background/cloud${rand(1, 6)}.png`" alt="" 
      :style="`animation-delay: -${rand(0, 150)};`"
      :class="`h-100% cloud scale${rand(0, 5)} duration${rand(0, 5)} start${rand(0, 5)} position${rand(0, 5)} absolute -z-1 mix-blend-overlay`"/>
  </transition-group>
  <transition-group name="fade" tag="div" v-else>
    <img v-for="cloud in clouds" :key="'night-' + cloud" :src="`/src/assets/background/cloud${rand(1, 6)}.png`" alt="" 
      :style="`animation-delay: -${rand(0, 150)};`"
      :class="`h-100% cloud scale${rand(0, 5)} duration${rand(0, 5)} start${rand(0, 5)} position${rand(0, 5)} absolute -z-1 mix-blend-multiply`"/>
  </transition-group>

  <transition name="fade" class="absolute top-[5%] left-[16%] scale-70 w-[298px] h-[223px]">
    <div v-if="!isDay && clouds < 15">
      <img :src="`/src/assets/background/moon1.png`" alt="" class="absolute top-0 left-0 w-full h-full opacity-80 -z-1"/>
      <img :src="`/src/assets/background/glow.png`" alt="" class="absolute top-0 left-0 scale-200 opacity-5 mix-blend-soft-light -z-5"/>
    </div>
  </transition>

  <transition name="fade">
    <img v-if="isDay && clouds < 15" :src="`/src/assets/background/sun1.png`" alt="" class="absolute top-[-10%] left-0 -z-1 scale-50"/>
  </transition>
</template>

<script setup lang="ts">
  import { ref, computed } from 'vue';
  import { useWeather, useIsDay } from '../composables/AppData'

  const weatherData = useWeather()
  const currentWeather = weatherData.value.timelines.minutely[0].values
  const clouds = ref(Math.round((currentWeather.cloudCover / 10) * 2));
  const isDay = computed(() => {
    const weather = weatherData.value
    if (!weather || !weather.timelines?.hourly?.[0]?.time) return null
    return useIsDay(weather.timelines.hourly[0].time)
  })

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
  .position0 {top: -5%;}
  .position1 {top: 0;}
  .position2 {top: 5%;}
  .position3 {top: 10%;}
  .position4 {top: 15%;}

  .duration0 {animation-duration: 50s;}
  .duration1 {animation-duration: 60s;}
  .duration2 {animation-duration: 70s;}
  .duration3 {animation-duration: 80s;}
  .duration4 { animation-duration: 110s;}

  .scale0 {scale: 150%;}
  .scale1 {scale: 200%;}
  .scale2 {scale: 170%;}
  .scale3 {scale: 140%;}
  .scale4 {scale: 160%;}

  .start0 {animation-delay: 0s;}
  .start1 {animation-delay: -20s;}
  .start2 {animation-delay: -40s;}
  .start3 {animation-delay: -60s;}
  .start4 {animation-delay: -80s;}

  .fade-enter-from { opacity: 0; }
  .fade-enter-active { opacity: 5s; }
  .fade-enter-to { opacity: 1; }

  .fade-leave-from { opacity: 1 }
  .fade-leave-active { opacity: 5s; }
  .fade-leave-to { opacity: 0; }

  @keyframes hover {
    0% {transform: translateX(-20%); opacity: 0;}
    10% {opacity: 1;}
    90% {opacity: 1;}
    100% {transform: translateX(30%); opacity: 0}
  }
</style>