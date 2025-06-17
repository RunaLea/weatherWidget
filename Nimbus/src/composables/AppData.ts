import {onMounted, ref} from "vue";

const weather = ref()
const loading = ref(true)

export function isLoading() {return loading}

export function useWeather() {
  if (loading.value) {
    onMounted(async () => {
      const res = await fetch('http://localhost:8080/weather')
      weather.value = await res.json()
      loading.value = false
    })
  }
  return weather
}

export function useIsDay(hour: string) {
  const hourValue = useFormatHour(hour);
  const hourNum = Number(hourValue[0] + hourValue[1])

  if (hourNum >= 21 || hourNum < 6) { return false }
  if (hourNum < 21 && hourNum >= 6) { return true }
}

export function useWeatherIcon(code: number, hour: string | null) {
  const dayUrl = `/src/assets/tomorrow-icons/${code}0.png`
  const nightUrl = `/src/assets/tomorrow-icons/${code}1.png`

  if (hour) {
    if (!useIsDay(hour)) { return nightUrl }
    if (useIsDay(hour)) { return dayUrl }
  }

  if (useIsDay(useWeather().value.timelines.hourly[0].time)) { return dayUrl }
  if (!useIsDay(useWeather().value.timelines.hourly[0].time)) { return nightUrl }
}

export function useDayIcon(code: number) {
  return `/src/assets/tomorrow-icons/${code}0.png`
}

export function useFormatHour(iso: string) {
  const date = new Date(iso)
  return date.getHours().toString().padStart(2, '0') + ':00'
}

export function useFormatDay(dateStr: string) {
  const date = new Date(dateStr)
  return date.toLocaleDateString('en-US', { weekday: 'long' })
}