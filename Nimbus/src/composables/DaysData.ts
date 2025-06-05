import { reactive, ref } from "vue";
import dailyData from '../../ExampleJSON/JSONExampleDaily.json'

const dailyForecast = ref (dailyData.timelines.daily.slice(0, 6))

export function useDailyForecast() { return dailyForecast }

export function useFormatDay(dateStr: string) {
  const date = new Date(dateStr)
  return date.toLocaleDateString('en-US', { weekday: 'long' })
}

export function useWeatherIcon(code: number, day: boolean) {
  let src = "";

  if (day) { src = `/src/assets/tomorrow-icons/${code}0.png`; }
  if (!day) { src = `/src/assets/tomorrow-icons/${code}1.png`; }
  return src;
}
