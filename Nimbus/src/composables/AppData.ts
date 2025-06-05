import { ref } from "vue";
import { useFormatHour } from "./HoursData";

const isDay = ref(false);

export function useIsDay() { return isDay }

export function useWeatherIcon(code: number, hour: string | null) {
  let src = "";
  const dayUrl = `/src/assets/tomorrow-icons/${code}0.png`
  const nightUrl = `/src/assets/tomorrow-icons/${code}1.png`

  if (hour) {
    const hourValue = useFormatHour(hour);
    
    if (Number(hourValue[0] + hourValue[1]) >= 18) { 
    const img = new Image();

    img.src = nightUrl;
    if (img.height != 0) { src = nightUrl; }
    else { src = dayUrl }
    return src;
  }

    if(Number(hourValue[0] + hourValue[1]) < 18) {
      src = dayUrl;
      return src;
    }
  }

  if (isDay.value) { src = dayUrl; }

  if (!isDay.value) { 
    const img = new Image();

    img.src = nightUrl;
    if (img.height != 0) { src = nightUrl; }
    else { src = dayUrl }
  }

  return src;
}