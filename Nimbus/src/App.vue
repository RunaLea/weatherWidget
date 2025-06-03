<template>
  <CurrentWeather/>
  <ComingDays/>
  <ComingHours/>
</template>

<script setup lang="ts">
  import CurrentWeather from './components/CurrentWeather.vue';
  import ComingHours from './components/ComingHours.vue';
  import ComingDays from './components/ComingDays.vue';
  import {useTime, useWeather} from './composables/AppData'

  const weather = useWeather()
  
</script>
