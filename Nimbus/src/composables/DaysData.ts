import { reactive, ref } from "vue";

const date = reactive ({
  day: 0,
  month: 0,
  year: 0
})

const weather = ref('cloudy')

export function useWeather() {return weather}
export function useDate() {return date}