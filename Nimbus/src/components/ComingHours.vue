<template>
  <div class="bg-white/80 rounded-xl shadow p-4 w-full max-w-screen-md mx-auto mt-4 mb-4 text-black">
    <div class="text-xl font-semibold mb-4">Next Hours</div>
    <div class="flex gap-4 overflow-x-auto pb-2">
      <div v-for="hour in hours" :key="hour.time" class="flex flex-col items-center min-w-[64px]">
        <div class="text-sm">{{ formatHour(hour.time) }}</div>
        <span class="text-2xl my-1">{{ weatherCodeToEmoji[hour.values.weatherCode] || '❓' }}</span>
        <div class="font-bold">{{ hour.values.temperature }}°C</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { hourlyForecast } from '../composables/useWeatherMock'

const hours = hourlyForecast

const weatherCodeToEmoji: Record<number, string> = {
  1000: '☀️',
  1001: '☁️',
  1100: '🌤️',
  1101: '⛅',
  1102: '🌥️',
}

function formatHour(iso: string) {
  const date = new Date(iso)
  return date.getHours().toString().padStart(2, '0') + ':00'
}
</script>