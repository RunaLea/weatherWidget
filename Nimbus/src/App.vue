<template>
  <div v-if="loading">Loading weather...</div>
  <div v-else>
    <div class="absolute top-0 left-0 w-full min-h-screen max-h-[100vh] h-[100vh] overflow-y-auto overflow-x-hidden min-w-screen max-w-2xl mx-auto bg-local z-1" :class="{ 'night-bg': !isDay }">
      <Background/>
      <div id="app" class="w-full h-full min-w-screen max-w-2xl mx-auto bg-transparent flex flex-col items-center p-2 sm:p-4">
        <h1 class="text-3xl sm:text-4xl font-bold text-gray-800 mb-4 sm:mb-6 text-center">Nimbus Weather</h1>
          <CurrentWeather />
          <ComingHours />
          <ComingDays />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
  import Background from './components/Background.vue';
  import CurrentWeather from './components/CurrentWeather.vue';
  import ComingHours from './components/ComingHours.vue';
  import ComingDays from './components/ComingDays.vue';
  import {isLoading, useIsDay, useWeather, useWeatherIcon} from './composables/AppData'
  import {computed, watchEffect} from 'vue'
  import { useWeatherLabel } from './composables/CurrentData';

  const weatherData = useWeather()
  const weatherLabel = useWeatherLabel();
  const loading = isLoading()

  const isDay = computed(() => {
    const weather = weatherData.value
    if (!weather || !weather.timelines?.hourly?.[0]?.time) return null
    return useIsDay(weather.timelines.hourly[0].time)
  })

  watchEffect(() => {
    const weather = weatherData.value
    const hourly = weather?.timelines?.hourly?.[0]

    if (!hourly) return

    const iconUrl = useWeatherIcon(hourly.values.weatherCode, hourly.time)
    
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
