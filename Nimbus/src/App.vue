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
import { useCurrentWeather } from './composables/CurrentData';
import { useWeatherLabel } from './composables/CurrentData';
import { useWeatherIcon } from './composables/AppData';

const currentWeather = useCurrentWeather();
const isDay = useIsDay(currentWeather.time);
const weatherLabel = useWeatherLabel();

watchEffect(() => {
  document.body.classList.toggle('night-bg', !isDay);
  document.title = `Nimbus - ${weatherLabel.value}`;
  const url = useWeatherIcon(currentWeather.values.weatherCode, currentWeather.time);
  let link: HTMLLinkElement | null = document.querySelector("link[rel~='icon']");
  if (!link) {
    link = document.createElement('link');
    link.rel = 'icon';
    document.head.appendChild(link);
  }
  link.href = url || '';
});
</script>
