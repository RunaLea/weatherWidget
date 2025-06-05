<template>
  <div id="app" :class="{ 'night-bg': !isDay }" class="w-full min-w-screen max-w-2xl mx-auto bg-transparent flex flex-col items-center rounded-lg shadow-lg p-2 sm:p-4">
    <h1 class="text-3xl sm:text-4xl font-bold text-gray-800 mb-4 sm:mb-6 text-center">Nimbus Weather</h1>
      <CurrentWeather />
      <ComingHours />
      <ComingDays />
  </div>
</template>

<script setup lang="ts">
import CurrentWeather from './components/CurrentWeather.vue';
import ComingHours from './components/ComingHours.vue';
import ComingDays from './components/ComingDays.vue';
import { useIsDay } from './composables/AppData'
import { watchEffect } from 'vue'
const isDay = useIsDay();

watchEffect(() => {
  document.body.classList.toggle('night-bg', !isDay.value);
});
</script>
