<template>
  <div class="bg-white/80 rounded-xl shadow p-4 w-full max-w-screen-md mx-auto mt-4 mb-4 text-black">
    <div class="text-xl font-semibold mb-4">Next Days</div>
    <div class="flex flex-col gap-3">
      <div v-for="day in days" :key="day.time" class="flex items-center justify-between p-2 rounded hover:bg-gray-100 transition">
        <div class="flex items-center gap-3">
          <span class="text-2xl">{{ weatherCodeToEmoji[day.values.weatherCodeMax] || '❓' }}</span>
          <span class="font-medium">{{ formatDay(day.time) }}</span>
        </div>
        <div>
          <span class="font-semibold">{{ day.values.temperatureMax }}°C</span>
          <span class="text-gray-500 ml-2">/ {{ day.values.temperatureMin }}°C</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { dailyForecast } from '../composables/useWeatherMock'

const days = dailyForecast

const weatherCodeToEmoji: Record<number, string> = {
  1000: '☀️',
  1001: '☁️',
  1100: '🌤️',
  1101: '⛅',
  1102: '🌥️',
}

function formatDay(dateStr: string) {
  const date = new Date(dateStr)
  return date.toLocaleDateString('en-US', { weekday: 'long' })
}
</script>