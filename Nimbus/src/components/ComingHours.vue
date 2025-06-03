<template>
  <p>ComingHours:</p>
  <p>{{ weather }}</p>
  <br><br>
</template>

<script setup lang="ts">
  import { useWeather, useTime } from '../composables/HoursData'

  const weather = useWeather()
  
</script>