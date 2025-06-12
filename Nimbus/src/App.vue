<template>
  <div class="absolute top-0 left-0 w-[100vw] h-[100vw] bg-local z-1" :class="{ 'night-bg': !isDay }">
    <Background/>
    <div id="app" class="w-full h-[100%] min-w-screen max-w-2xl mx-auto bg-transparent flex flex-col items-center rounded-lg shadow-lg p-2 sm:p-4">
      <h1 class="text-3xl sm:text-4xl font-bold text-gray-800 mb-4 sm:mb-6 text-center">Nimbus Weather</h1>
        <CurrentWeather />
        <ComingHours />
        <ComingDays />
    </div>
  </div>
</template>

<script setup lang="ts">
import CurrentWeather from './components/CurrentWeather.vue';
import ComingHours from './components/ComingHours.vue';
import ComingDays from './components/ComingDays.vue';
import Background from './components/Background.vue';
import { useIsDay } from './composables/AppData'
import { watchEffect } from 'vue';
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
