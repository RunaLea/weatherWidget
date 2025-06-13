<template>
  <div
      class="card bg-white/80 rounded-xl shadow p-4 w-full max-w-screen-md mx-auto mt-4 mb-4 text-black">
    <div class="text-xl font-semibold mb-4">Next Days</div>
    <div class="flex flex-col gap-3">
      <div v-for="day in dailyForecast" :key="day.time"
           class="flex items-center p-2 rounded hover:bg-gray-100 transition">
        <div
            class=" hover:bg-gray-100 transition cursor-pointer w-full rounded"
            @click="toggleDetails(day.time)" :class="{'bg-gray-100' : openItem === day.time}"
        >
          <div class="flex justify-between gap-5">
            <div class="flex items-center gap-3">
              <img :src="useWeatherIcon(day.values.weatherCodeMax)" alt="img">
              <span class="font-medium">{{ useFormatDay(day.time) }}</span>
            </div>
            <div class="flex items-center">
              <span class="font-semibold">{{ day.values.temperatureMax }}°C</span>
              <span class="text-gray-500 ml-2">/ {{ day.values.temperatureMin }}°C</span>
            </div>
          </div>
          <transition name="accordion">
            <div v-if="openItem === day.time"
                 class="px-5 pb-5 text-sm text-gray-700 h-30 grid grid-cols-1 gap-0">
              <div class="flex items-center gap-5">
                <p>Humidity: {{ day.values.humidityAvg }}%</p>
                <p>Dewpoint: {{day.values.dewPointAvg}}</p>
                <p>Rain Intensity: {{day.values.rainIntensityAvg}}</p>
                <p>Wind Speed: {{ day.values.windSpeedAvg }} km/h</p>
                <p>Sunrise: {{ useFormatHour(day.values.sunriseTime) }}</p>
                <p>Sunset: {{ useFormatHour(day.values.sunsetTime) }}</p>
              </div>
            </div>
          </transition>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import {useFormatDay} from '../composables/DaysData'
import {useWeather, useWeatherIcon} from '../composables/AppData'
import {ref} from "vue";
import {useFormatHour} from "../composables/HoursData.ts";

const openItem = ref<string | null>(null)

function toggleDetails(dayTime: string) {
  openItem.value = openItem.value === dayTime ? null : dayTime
}

const weatherData = useWeather()
const dailyForecast = weatherData.value.timelines.daily


</script>
<style scoped>
.accordion-enter-active,
.accordion-leave-active {
  transition: max-height 0.3s ease, opacity 0.3s ease, padding 0.3s ease;
}

.accordion-enter-from,
.accordion-leave-to {
  max-height: 0;
  opacity: 0;
  padding-top: 0;
  padding-bottom: 0;
}

.accordion-enter-to,
.accordion-leave-from {
  max-height: 200px; /* adjust based on expected content */
  opacity: 1;
  padding-top: 16px; /* match your pb-4 or pt-4 */
  padding-bottom: 16px;
}
</style>