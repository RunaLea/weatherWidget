import { useFormatHour } from "./HoursData";
import { useCurrentWeather } from "./CurrentData";

const currentWeather = useCurrentWeather()

export function useIsDay(hour: string) { 
  const hourValue = useFormatHour(hour);
  const hourNum = Number(hourValue[0] + hourValue[1])

  if (hourNum >= 21 || hourNum < 6) { return false }
  if (hourNum < 21 && hourNum >= 6) { return true }
}

export function useWeatherIcon(code: number, hour: string | null) {
  const dayUrl = `/src/assets/tomorrow-icons/${code}0.png`
  const nightUrl = `/src/assets/tomorrow-icons/${code}1.png`
  
  if (!isImage(nightUrl)) { return dayUrl }

  if (hour) {
    if (!useIsDay(hour)) { return nightUrl }
    if (useIsDay(hour)) { return dayUrl }
  }

  if (useIsDay(currentWeather.time)) { return dayUrl }
  if (!useIsDay(currentWeather.time)) { return nightUrl }
}

export function isImage(url: string) {
  const img = new Image();
  img.src = url
  if (img.height != 0) { return true; }
  else { return false }
}