import { reactive, ref } from "vue";

const time = reactive ({
  hours: 0,
  seconds: 0,
  milliseconds: 0
})

const weather = ref('cloudy')

export function useWeather() {return weather}
export function useTime() {return time}