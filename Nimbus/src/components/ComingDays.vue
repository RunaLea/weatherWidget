<template>
  <div class="card w-full max-w-xl h-72 flex flex-col items-center overflow-y-auto text-black">
    <div class="text-lg font-semibold mb-0 sticky top-0 z-10 w-full text-center border-b border-gray-200">Next Days</div>
    <div class="flex flex-col gap-2 w-full">
      <div v-for="day in dailyForecast" :key="day.time"
           class="flex items-center p-1 rounded hover:bg-gray-100 transition w-full min-h-[48px]">
        <div
            class="hover:bg-gray-100 transition cursor-pointer w-full rounded"
            @click="toggleDetails(day.time)" :class="{'bg-gray-100' : openItem === day.time}"
        >
          <div class="flex justify-between gap-3 items-center">
            <div class="flex items-center gap-2">
              <img :src="useWeatherIcon(day.values.weatherCodeMax, day.time)" alt="img" class="w-7 h-7">
              <span class="font-medium text-sm">{{ useFormatDay(day.time) }}</span>
            </div>
            <div class="flex items-center text-sm">
              <span class="font-semibold">{{ day.values.temperatureMax }}°C</span>
              <span class="text-gray-500 ml-1">/ {{ day.values.temperatureMin }}°C</span>
            </div>
          </div>
          <transition name="accordion">
            <div v-if="openItem === day.time"
                 class="px-2 pb-2 text-xs text-gray-700 h-24 grid grid-cols-1 gap-0">
              <div class="flex items-center gap-3 flex-wrap">
                <p>Humidity: {{ day.values.humidityAvg }}%</p>
                <p>Dewpoint: {{day.values.dewPointAvg}}</p>
                <p>Rain: {{day.values.rainIntensityAvg}}</p>
                <p>Wind: {{ day.values.windSpeedAvg }} km/h</p>
                <p>Sunrise: {{ new Date(day.values.sunriseTime).toLocaleTimeString() }}</p>
                <p>Sunset: {{ new Date(day.values.sunsetTime).toLocaleTimeString()  }}</p>
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
  max-height: 100px;
  opacity: 1;
  padding-top: 8px;
  padding-bottom: 8px;
}
</style>