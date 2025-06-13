<template>
  <div class="card bg-white/80 rounded-xl shadow p-2 w-full flex flex-col justify-start items-center text-black">
    <div class="text-xl font-semibold mb-2">Next Hours</div>
    <div class="flex gap-4 w-full overflow-x-auto pb-1 no-scrollbar">
      <div v-for="hour in hourlyForecast" :key="hour.time" class="flex flex-col items-center min-w-[64px]">
        <div class="text-sm">{{ useFormatHour(hour.time) }}</div>
        <img v-if="hour" :src="useWeatherIcon(hour.values.weatherCode, hour.time)" @error="event => ((event.target as HTMLImageElement).src = useDayIcon(hour.values.weatherCode))">
        <div class="font-bold">{{ hour.values.temperature }}°C</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {useWeather, useWeatherIcon, useDayIcon} from '../composables/AppData'
import {useFormatHour} from "../composables/HoursData.ts";


const weatherData = useWeather()
const hourlyForecast = weatherData.value.timelines.hourly.slice(0, 60)

</script>