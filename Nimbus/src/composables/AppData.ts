import {onMounted, ref} from "vue";
import {useFormatHour} from "./HoursData.ts";

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

const weather = ref()
const loading = ref(true)

export function isLoading() {return loading}

export function useIsDay(hour: string) {
  const hourValue = useFormatHour(hour);
  const hourNum = Number(hourValue[0] + hourValue[1])
// FIXME doesnt work :(
  if (hourNum >= 21 || hourNum < 6) {
    return false
  }
  if (hourNum < 21 && hourNum >= 6) {
    return true
  }
}

export function useWeatherIcon(code: number, hour: string | null) {
  const dayUrl = `/src/assets/tomorrow-icons/${code}0.png`
  const nightUrl = `/src/assets/tomorrow-icons/${code}1.png`

  if (!isImage(nightUrl)) {
    return dayUrl
  }

  if (hour) {
    if (!useIsDay(hour)) {
      return nightUrl
    }
    if (useIsDay(hour)) {
      return dayUrl
    }
  }

  if (useIsDay(useWeather().value.timelines.hourly[0].time)) {
    return dayUrl
  }
  if (!useIsDay(useWeather().value.timelines.hourly[0].time)) {
    return nightUrl
  }
}

export function isImage(url: string) {
  const img = new Image();
  img.src = url
  if (img.height != 0) {
    return true;
  } else {
    return false
  }
}
