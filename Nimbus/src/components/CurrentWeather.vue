<template>
  <div class="bg-white/80 rounded-xl shadow p-4 w-full max-w-screen-md mx-auto mb-4 text-black">
    <div class="text-3xl font-bold mb-2">{{ current.values.temperature }}°C</div>
    <div class="mb-4 flex items-center gap-2">
      <span class="text-3xl">{{ weatherEmoji }}</span>
      <span class="capitalize">{{ weatherLabel }}</span>
    </div>
    <div class="flex justify-center gap-6">
      <div>
        <span class="font-semibold block">Wind</span>
        <span>{{ current.values.windSpeed }} km/h</span>
      </div>
      <div>
        <span class="font-semibold block">Humidity</span>
        <span>{{ current.values.humidity }}%</span>
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