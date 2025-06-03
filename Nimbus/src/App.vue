<template>
  <div class="min-h-screen min-w-screen bg-gradient-to-br from-blue-200 via-sky-300 to-indigo-200 flex flex-col items-center py-4 px-2 sm:px-4">
    <h1 class="text-4xl font-bold text-gray-800 mb-6">Nimbus Weather</h1>
    <CurrentWeather />
    <ComingHours />
    <ComingDays />
  </div>
</template>

<script setup lang="ts">
import CurrentWeather from './components/CurrentWeather.vue';
import ComingHours from './components/ComingHours.vue';
import ComingDays from './components/ComingDays.vue';
</script>
