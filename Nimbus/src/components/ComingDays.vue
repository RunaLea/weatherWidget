<template>
  <div class="bg-white/80 rounded-xl shadow p-4 w-full max-w-screen-md mx-auto mt-4 mb-4 text-black">
    <div class="text-xl font-semibold mb-4">Next Days</div>
    <div class="flex flex-col gap-3">
      <div v-for="day in dailyForecast" :key="day.time" class="flex items-center justify-between p-2 rounded hover:bg-gray-100 transition">
        <div class="flex items-center gap-3">
          <img :src="useWeatherIcon(day.values.weatherCodeMax)">
          <span class="font-medium">{{ useFormatDay(day.time) }}</span>
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
import { useDailyForecast, useFormatDay } from '../composables/DaysData'
import { useWeatherIcon } from '../composables/AppData'

const dailyForecast = useDailyForecast()

</script>