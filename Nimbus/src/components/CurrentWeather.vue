<template>
  <p>CurrentWeather:</p>
  <p>{{ weather }}</p>
  <br><br>
</template>

<script setup lang="ts">
  import { useWeather, useTime } from '../composables/CurrentData'

  const weather = useWeather()
  
</script>