<template>
  <p>ComingDays:</p>
  <p>{{ weather }}</p>
  <br><br>
</template>

<script setup lang="ts">
  import { useWeather, useTime } from '../composables/DaysData'

  const weather = useWeather()
  
</script>