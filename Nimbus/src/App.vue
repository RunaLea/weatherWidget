<template>
  <div class="min-h-screen min-w-screen flex items-center justify-center">
    <div class="w-full max-w-2xl mx-auto bg-transparent flex flex-col items-center rounded-lg shadow-lg p-2 sm:p-4">
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
</script>
