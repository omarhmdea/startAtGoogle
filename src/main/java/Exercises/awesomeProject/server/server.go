package server

import (
	"awesomeProject/server/scraping/timeAndDate"
	"awesomeProject/server/scraping/weatherAndRadar"
	"awesomeProject/server/scraping/weatherAtlas"
	"awesomeProject/server/structs"
	"awesomeProject/server/utils"
)

func WillItRain(country string, cityName string, days int) []float64 {
	utils.ValidDays(days)

	timeAndDateResult := timeAndDate.WillItRain(country, cityName, days)
	weatherAtlasResult := weatherAtlas.WillItRain(country, cityName, days)
	weatherAndRadarResult := weatherAndRadar.WillItRain(cityName, days)

	return utils.CalcArraysAvg(timeAndDateResult, weatherAtlasResult, weatherAndRadarResult)
}

func NextRainDay(country string, cityName string) int {

	timeAndDateResult := timeAndDate.NextRainDay(country, cityName)
	weatherAtlasResult := weatherAtlas.NextRainDay(country, cityName)
	weatherAndRadarResult := weatherAndRadar.NextRainDay(cityName)

	var positiveRes []int

	if timeAndDateResult > 0 {
		positiveRes = append(positiveRes, timeAndDateResult)
	}

	if weatherAtlasResult > 0 {
		positiveRes = append(positiveRes, weatherAtlasResult)
	}

	if weatherAndRadarResult > 0 {
		positiveRes = append(positiveRes, weatherAndRadarResult)
	}

	if len(positiveRes) > 0 {
		return int(utils.AvgOFArray(positiveRes))
	}

	return -1
}

func AverageTemp(country string, cityName string, days int) float64 {
	utils.ValidDays(days)

	timeAndDateResult := timeAndDate.AverageTemp(country, cityName, days)
	weatherAtlasResult := weatherAtlas.AverageTemp(country, cityName, days)
	weatherAndRadarResult := weatherAndRadar.AverageTemp(cityName, days)

	return utils.AverageOf3Elements(timeAndDateResult, weatherAtlasResult, weatherAndRadarResult)
}

func TempArray(country string, cityName string, days int) structs.Temperature[float64] {
	utils.ValidDays(days)
	var temperature = structs.Temperature[float64]{}

	timeAndDateTemperatureResult := timeAndDate.TempArray(country, cityName, days)
	weatherAtlasTemperatureResult := weatherAtlas.TempArray(country, cityName, days)
	weatherAndRadarTemperatureResult := weatherAndRadar.TempArray(cityName, days)

	temperature.MaxTemp = utils.CalcArraysAvg(timeAndDateTemperatureResult.MaxTemp, weatherAtlasTemperatureResult.MaxTemp, weatherAndRadarTemperatureResult.MaxTemp)
	temperature.MinTemp = utils.CalcArraysAvg(timeAndDateTemperatureResult.MinTemp, weatherAtlasTemperatureResult.MinTemp, weatherAndRadarTemperatureResult.MinTemp)

	return temperature
}

func WeatherSummary(country string, cityName string) structs.Summary[float64] {
	summary := structs.Summary[float64]{}

	timeAndDateResult := timeAndDate.WeatherSummary(country, cityName)
	weatherAtlasResult := weatherAtlas.WeatherSummary(country, cityName)
	weatherAndRadarResult := weatherAndRadar.WeatherSummary(cityName)

	summary.MaxTemp = utils.AverageOf3Elements(timeAndDateResult.MaxTemp, weatherAtlasResult.MaxTemp, weatherAndRadarResult.MaxTemp)
	summary.MinTemp = utils.AverageOf3Elements(timeAndDateResult.MinTemp, weatherAtlasResult.MinTemp, weatherAndRadarResult.MinTemp)
	summary.Wind = utils.AverageOf3Elements(timeAndDateResult.Wind, weatherAtlasResult.Wind, weatherAndRadarResult.Wind)
	summary.Humidity = utils.AverageOf3Elements(timeAndDateResult.Humidity, weatherAtlasResult.Humidity, weatherAndRadarResult.Humidity)
	summary.ChanceOfRain = utils.AverageOf3Elements(timeAndDateResult.ChanceOfRain, weatherAtlasResult.ChanceOfRain, weatherAndRadarResult.ChanceOfRain)

	return summary

}
