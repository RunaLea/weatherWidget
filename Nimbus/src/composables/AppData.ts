import { ref } from "vue";
import { useFormatHour } from "./HoursData";

const isDay = ref(false);

export function useIsDay() { return isDay }

export function useWeatherIcon(code: number, hour: string | null) {
  const dayUrl = `/src/assets/tomorrow-icons/${code}0.png`
  const nightUrl = `/src/assets/tomorrow-icons/${code}1.png`
  
  if (!isImage(nightUrl)) { return dayUrl }

  if (hour) {
    const hourValue = useFormatHour(hour);
    const hourNum = Number(hourValue[0] + hourValue[1])
    
    if (hourNum >= 18 || hourNum < 6) { return nightUrl }
    if (hourNum < 18 && hourNum >= 6) { return dayUrl }
  }

  if (isDay.value) { return dayUrl }
  if (!isDay.value) { return nightUrl }
}

export function isImage(url: string) {
  const img = new Image();
  img.src = url
  if (img.height != 0) { return true; }
  else { return false }
}