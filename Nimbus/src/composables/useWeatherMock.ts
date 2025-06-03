import hourlyData from '../../ExampleJSON/JSONExampleHourly.json'
import dailyData from '../../ExampleJSON/JSONExampleDaily.json'

export const currentWeather = hourlyData.timelines.hourly[0]

export const hourlyForecast = hourlyData.timelines.hourly.slice(0, 6)

export const dailyForecast = dailyData.timelines.daily.slice(0, 5) 