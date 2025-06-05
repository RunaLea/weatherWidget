import { ref, computed } from "vue";
import hourlyData from '../../ExampleJSON/JSONExampleHourly.json'

const currentWeather = hourlyData.timelines.hourly[0]

const weatherCodeToLabel: Record<number, string> = {
  1000: 'Clear',
  1001: 'Cloudy',
  1100: 'Mostly Clear',
  1101: 'Partly Cloudy',
  1102: 'Mostly Cloudy',
}

const weatherLabel = computed(() => weatherCodeToLabel[currentWeather.values.weatherCode] || 'Unknown')

export function useWeatherLabel() { return weatherLabel }
export function useCurrentWeather() { return currentWeather }