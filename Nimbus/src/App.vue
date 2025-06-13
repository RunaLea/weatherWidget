<template>
  <div v-if="loading">Loading weather...</div>
  <div v-else>
    <div v-if="weatherData" id="app" :class="[{'night-bg': !isDay}, 'flex flex-col items-center justify-center min-h-screen w-full sm:p-8 h-screen']">
      <h1 class="text-3xl sm:text-4xl font-bold text-gray-800 sm:mb-6 text-center">Nimbus Weather</h1>
      <div class="flex flex-col items-center justify-center w-full gap-6">
        <CurrentWeather />
        <ComingHours />
        <ComingDays />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import CurrentWeather from './components/CurrentWeather.vue';
import ComingHours from './components/ComingHours.vue';
import ComingDays from './components/ComingDays.vue';
import {isLoading, useIsDay, useWeather} from './composables/AppData'
import {computed, watchEffect} from 'vue'
import { useWeatherLabel } from './composables/CurrentData';
import { useWeatherIcon } from './composables/AppData';

const weatherData = useWeather()
const isDay = computed(() => {
  const weather = weatherData.value
  if (!weather || !weather.timelines?.hourly?.[0]?.time) return null
  return useIsDay(weather.timelines.hourly[0].time)
})

const weatherLabel = useWeatherLabel();
const loading = isLoading()

watchEffect(() => {
  const weather = weatherData.value
  const hourly = weather?.timelines?.hourly?.[0]

  if (!hourly) return

  const iconUrl = useWeatherIcon(hourly.weatherCode, hourly.time)

  document.body.classList.toggle('night-bg', !isDay)
  document.title = `Nimbus - ${weatherLabel.value}`

  let link: HTMLLinkElement | null = document.querySelector("link[rel~='icon']")
  if (!link) {
    link = document.createElement('link')
    link.rel = 'icon'
    document.head.appendChild(link)
  }
  link.href = iconUrl || ''
})
</script>
