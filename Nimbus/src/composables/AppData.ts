import { ref } from "vue";
import { useFormatHour } from "./HoursData";

const isDay = ref(true);

export function useIsDay() { return isDay }
export function useWeatherIcon(code: number, hour: string | null) {
  let src = "";

  if (hour) {
    const hourValue = useFormatHour(hour);
    
    if (Number(hourValue[0] + hourValue[1]) >= 18) {
      src = `/src/assets/tomorrow-icons/${code}1.png`;
      return src;
    }
    if(Number(hourValue[0] + hourValue[1]) < 18) {
      src = `/src/assets/tomorrow-icons/${code}0.png`;
      return src;
    }
  }

  if (isDay.value) { src = `/src/assets/tomorrow-icons/${code}0.png`; }
  if (!isDay.value) { src = `/src/assets/tomorrow-icons/${code}1.png`; }
  return src;
}