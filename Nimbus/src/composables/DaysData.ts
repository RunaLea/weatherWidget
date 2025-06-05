import { ref } from "vue";
import dailyData from '../../ExampleJSON/JSONExampleDaily.json'

const dailyForecast = ref (dailyData.timelines.daily.slice(0, 6))

export function useDailyForecast() { return dailyForecast }

export function useFormatDay(dateStr: string) {
  const date = new Date(dateStr)
  return date.toLocaleDateString('en-US', { weekday: 'long' })
}
