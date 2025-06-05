import { ref } from "vue";
import hourlyData from '../../ExampleJSON/JSONExampleHourly.json';

const hourlyForecast = ref (hourlyData.timelines.hourly.slice(0, 6));

export function useHourlyForecast() { return hourlyForecast }

export function useFormatHour(iso: string) {
  const date = new Date(iso)
  return date.getHours().toString().padStart(2, '0') + ':00'
}