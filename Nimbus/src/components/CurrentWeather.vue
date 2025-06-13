<template>
  <div v-if="currentWeather" class="card w-80 h-80 bg-gradient-to-br from-white/90 to-gray-100/80 rounded-2xl shadow-xl flex flex-col items-center justify-center text-black p-4">
    <div class="w-full flex flex-col items-center justify-center flex-1 gap-1">
      <span class="text-base font-medium text-gray-700 mb-0.5">{{ cityName }}</span>
      <img :src="useWeatherIcon(currentWeather.weatherCode, currentWeather.time)" class="w-10 h-10 mb-1">
      <span class="text-5xl font-extrabold tracking-tight mb-0.5">{{ currentWeather.temperature }}°</span>
      <span class="text-sm font-medium text-gray-500 capitalize mb-1">{{ weatherLabel }}</span>
    </div>
    <div class="flex justify-center gap-4 w-full mt-1 text-xs">
      <div class="flex flex-col items-center">
        <span class="font-semibold text-gray-700">Wind</span>
        <span>{{ currentWeather.windSpeed }} <span class="text-gray-400">km/h</span></span>
      </div>
      <div class="flex flex-col items-center">
        <span class="font-semibold text-gray-700">Humidity</span>
        <span>{{ currentWeather.humidity }}<span class="text-gray-400">%</span></span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useWeatherLabel } from '../composables/CurrentData'
import {useWeather, useWeatherIcon} from '../composables/AppData'

const weatherData = useWeather()
const currentWeather = weatherData.value.timelines.minutely[0].values
const weatherLabel = useWeatherLabel()
const cityName = weatherData.value.location?.name || 'Weather'
</script>