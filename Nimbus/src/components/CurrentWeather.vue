<template>
  <div class="bg-gradient-to-br from-white/90 to-gray-100/80 rounded-2xl shadow-xl p-8 w-full max-w-md mx-auto mb-6 text-black flex flex-col items-center">
    <div class="flex flex-col items-center mb-4">
      <span class="text-6xl mb-2">{{ weatherEmoji }}</span>
      <span class="text-5xl font-extrabold tracking-tight mb-1">{{ current.values.temperature }}°C</span>
      <span class="text-lg font-medium text-gray-500 capitalize">{{ weatherLabel }}</span>
    </div>
    <div class="flex justify-center gap-10 w-full mt-2">
      <div class="flex flex-col items-center">
        <span class="font-semibold text-gray-700">Wind</span>
        <span class="text-lg">{{ current.values.windSpeed }} <span class="text-gray-400 text-base">km/h</span></span>
      </div>
      <div class="flex flex-col items-center">
        <span class="font-semibold text-gray-700">Humidity</span>
        <span class="text-lg">{{ current.values.humidity }}<span class="text-gray-400 text-base">%</span></span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { currentWeather } from '../composables/useWeatherMock'
import { computed } from 'vue'

const current = currentWeather

const weatherCodeToLabel: Record<number, string> = {
  1000: 'Clear',
  1001: 'Cloudy',
  1100: 'Mostly Clear',
  1101: 'Partly Cloudy',
  1102: 'Mostly Cloudy',
}
const weatherCodeToEmoji: Record<number, string> = {
  1000: '☀️',
  1001: '☁️',
  1100: '🌤️',
  1101: '⛅',
  1102: '🌥️',
}

const weatherLabel = computed(() => weatherCodeToLabel[current.values.weatherCode] || 'Unknown')
const weatherEmoji = computed(() => weatherCodeToEmoji[current.values.weatherCode] || '❓')
</script>