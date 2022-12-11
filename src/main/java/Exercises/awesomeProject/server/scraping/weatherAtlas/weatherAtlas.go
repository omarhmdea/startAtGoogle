package weatherAtlas

import (
	"awesomeProject/server/constants"
	"awesomeProject/server/structs"
	"awesomeProject/server/utils"
	"fmt"
	"github.com/PuerkitoBio/goquery"
	"strings"
)

func Scrap(country string, cityName string) structs.Forecast {
	var weekForecast = structs.Forecast{}

	weekForecast.MaxTemp = getWeatherParameterWeatherAtlas(country, cityName, "max", constants.MAX_NUM_OF_DAYS)
	weekForecast.MinTemp = getWeatherParameterWeatherAtlas(country, cityName, "min", constants.MAX_NUM_OF_DAYS)
	weekForecast.Wind = getWeatherParameterWeatherAtlas(country, cityName, "wind", constants.MAX_NUM_OF_DAYS)
	weekForecast.Humidity = getWeatherParameterWeatherAtlas(country, cityName, "humidity", constants.MAX_NUM_OF_DAYS)
	weekForecast.ChanceOfRain = getWeatherParameterWeatherAtlas(country, cityName, "chanceOfRain", constants.MAX_NUM_OF_DAYS)

	return weekForecast
}

func WillItRain(country string, cityName string, days int) []int {
	utils.ValidDays(days)
	return getWeatherParameterWeatherAtlas(country, cityName, "chanceOfRain", days)
}

func NextRainDay(country string, cityName string) int {
	res := getWeatherParameterWeatherAtlas(country, cityName, "chanceOfRain", constants.MAX_NUM_OF_DAYS)
	for index, value := range res {
		if value >= 50 {
			return index + 1
		}
	}
	return -1
}

func AverageTemp(country string, cityName string, days int) float64 {
	utils.ValidDays(days)
	res := getWeatherParameterWeatherAtlas(country, cityName, "max", days)
	return utils.AvgOFArray(res)
}

func TempArray(country string, cityName string, days int) structs.Temperature[int] {
	utils.ValidDays(days)
	var temperature = structs.Temperature[int]{}

	temperature.MaxTemp = getWeatherParameterWeatherAtlas(country, cityName, "max", days)
	temperature.MinTemp = getWeatherParameterWeatherAtlas(country, cityName, "min", days)

	return temperature
}

func WeatherSummary(country string, cityName string) structs.Summary[int] {
	summary := structs.Summary[int]{}

	summary.MaxTemp = getWeatherParameterWeatherAtlas(country, cityName, "max", 1)[0]
	summary.MinTemp = getWeatherParameterWeatherAtlas(country, cityName, "min", 1)[0]
	summary.Wind = getWeatherParameterWeatherAtlas(country, cityName, "wind", 1)[0]
	summary.Humidity = getWeatherParameterWeatherAtlas(country, cityName, "humidity", 1)[0]
	summary.ChanceOfRain = getWeatherParameterWeatherAtlas(country, cityName, "chanceOfRain", 1)[0]

	return summary

}

func getWeatherParameterWeatherAtlas(country string, cityName string, param string, days int) []int {
	url := fmt.Sprintf("https://www.weather-atlas.com/en/%s/%s-long-term-weather-forecast", country, cityName)
	doc := utils.GetRequest(url)

	var weekForecast = structs.Forecast{}

	doc.Find("div.row.px-3.py-2").Each(func(i int, selection *goquery.Selection) {
		if i < days {
			selection.Find("li").Each(func(j int, item *goquery.Selection) {
				switch j {
				case 0:
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[0:len(item.Text())-3], &weekForecast.MaxTemp)
					break
				case 1:
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[0:len(item.Text())-3], &weekForecast.MinTemp)
					break
				case 2:
					splitWind := strings.Split(item.Text()[6:], "km/h  ")
					utils.ConvertStringToIntAndAppendToSlice(splitWind[0], &weekForecast.Wind)
					break
				case 3:
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[10:len(item.Text())-1], &weekForecast.Humidity)
					break
				case 5:
					splitChance := strings.Split(item.Text()[21:], "%")
					utils.ConvertStringToIntAndAppendToSlice(splitChance[0], &weekForecast.ChanceOfRain)
					break
				}
			})
		}
	})

	switch param {
	case "max":
		return weekForecast.MaxTemp
	case "min":
		return weekForecast.MinTemp
	case "wind":
		return weekForecast.Wind
	case "humidity":
		return weekForecast.Humidity
	case "chanceOfRain":
		return weekForecast.ChanceOfRain
	}

	return nil
}
