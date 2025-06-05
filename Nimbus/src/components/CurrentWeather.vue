<template>
  <div class="bg-gradient-to-br from-white/90 to-gray-100/80 rounded-2xl shadow-xl p-8 w-full max-w-md mx-auto mb-6 text-black flex flex-col items-center">
    <div class="flex flex-col items-center mb-4">
      <img :src="useWeatherIcon(currentWeather.values.weatherCode, currentWeather.time.hour)">
      <span class="text-5xl font-extrabold tracking-tight mb-1">{{ currentWeather.values.temperature }}°C</span>
      <span class="text-lg font-medium text-gray-500 capitalize">{{ weatherLabel }}</span>
    </div>
    <div class="flex justify-center gap-10 w-full mt-2">
      <div class="flex flex-col items-center">
        <span class="font-semibold text-gray-700">Wind</span>
        <span class="text-lg">{{ currentWeather.values.windSpeed }} <span class="text-gray-400 text-base">km/h</span></span>
      </div>
      <div class="flex flex-col items-center">
        <span class="font-semibold text-gray-700">Humidity</span>
        <span class="text-lg">{{ currentWeather.values.humidity }}<span class="text-gray-400 text-base">%</span></span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useCurrentWeather, useWeatherLabel } from '../composables/CurrentData'
import { useWeatherIcon } from '../composables/AppData'
import { computed } from 'vue'

const weatherLabel = useWeatherLabel()
const currentWeather = useCurrentWeather()

</script>