<template>
  <div class="card bg-white/30 rounded-xl shadow p-4 w-full max-w-screen-md mx-auto mt-4 mb-4 text-black">
    <div class="text-xl font-semibold mb-4">Next Hours</div>
    <div class="flex gap-4 overflow-x-auto pb-2">
      <div v-for="hour in hourlyForecast" :key="hour.time" class="flex flex-col items-center min-w-[64px]">
        <div class="text-sm">{{ useFormatHour(hour.time) }}</div>
        <img v-if="hour" :src="useWeatherIcon(hour.values.weatherCode, hour.time)" @error="event => ((event.target as HTMLImageElement).src = useDayIcon(hour.values.weatherCode))">
        <div class="font-bold">{{ hour.values.temperature }}°C</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
  import {useWeather, useWeatherIcon, useDayIcon, useFormatHour} from '../composables/AppData'

  const weatherData = useWeather()
  const hourlyForecast = weatherData.value.timelines.hourly.slice(0, 60)

</script>