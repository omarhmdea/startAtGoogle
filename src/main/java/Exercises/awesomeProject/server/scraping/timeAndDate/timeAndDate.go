package timeAndDate

import (
	"awesomeProject/server/constants"
	"awesomeProject/server/structs"
	"awesomeProject/server/utils"
	"fmt"
	"github.com/PuerkitoBio/goquery"
)

func Scrap(country string, cityName string) structs.Forecast {
	var weekForecast = structs.Forecast{}

	weekForecast.MaxTemp = getWeatherParameterTimeAndDate(country, cityName, "max", constants.MAX_NUM_OF_DAYS)
	weekForecast.MinTemp = getWeatherParameterTimeAndDate(country, cityName, "min", constants.MAX_NUM_OF_DAYS)
	weekForecast.Wind = getWeatherParameterTimeAndDate(country, cityName, "wind", constants.MAX_NUM_OF_DAYS)
	weekForecast.Humidity = getWeatherParameterTimeAndDate(country, cityName, "humidity", constants.MAX_NUM_OF_DAYS)
	weekForecast.ChanceOfRain = getWeatherParameterTimeAndDate(country, cityName, "chanceOfRain", constants.MAX_NUM_OF_DAYS)

	return weekForecast
}

func WillItRain(country string, cityName string, days int) []int {
	utils.ValidDays(days)
	return getWeatherParameterTimeAndDate(country, cityName, "chanceOfRain", days)
}

func NextRainDay(country string, cityName string) int {
	res := getWeatherParameterTimeAndDate(country, cityName, "chanceOfRain", constants.MAX_NUM_OF_DAYS)
	for index, value := range res {
		if value >= 50 {
			return index + 1
		}
	}
	return -1
}

func AverageTemp(country string, cityName string, days int) float64 {
	utils.ValidDays(days)
	res := getWeatherParameterTimeAndDate(country, cityName, "max", days)
	return utils.AvgOFArray(res)
}

func TempArray(country string, cityName string, days int) structs.Temperature[int] {
	utils.ValidDays(days)
	var temperature = structs.Temperature[int]{}

	temperature.MaxTemp = getWeatherParameterTimeAndDate(country, cityName, "max", days)
	temperature.MinTemp = getWeatherParameterTimeAndDate(country, cityName, "min", days)

	return temperature
}

func WeatherSummary(country string, cityName string) structs.Summary[int] {
	summary := structs.Summary[int]{}

	summary.MaxTemp = getWeatherParameterTimeAndDate(country, cityName, "max", 1)[0]
	summary.MinTemp = getWeatherParameterTimeAndDate(country, cityName, "min", 1)[0]
	summary.Wind = getWeatherParameterTimeAndDate(country, cityName, "wind", 1)[0]
	summary.Humidity = getWeatherParameterTimeAndDate(country, cityName, "humidity", 1)[0]
	summary.ChanceOfRain = getWeatherParameterTimeAndDate(country, cityName, "chanceOfRain", 1)[0] * 100

	return summary

}
func getWeatherParameterTimeAndDate(country string, cityName string, param string, days int) []int {
	url := fmt.Sprintf("https://www.timeanddate.com/weather/%s/%s/ext", country, cityName)
	doc := utils.GetRequest(url)

	var weekForecast = structs.Forecast{}

	doc.Find("tbody>tr").Each(func(i int, selection *goquery.Selection) {
		if i < days {
			selection.Find("td").Each(func(j int, item *goquery.Selection) {
				switch j {
				case 1:
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[0:len(item.Text())-10], &weekForecast.MaxTemp)
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[len(item.Text())-7:len(item.Text())-5], &weekForecast.MinTemp)
					break
				case 4:
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[0:len(item.Text())-5], &weekForecast.Wind)
					break
				case 6:
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[0:len(item.Text())-1], &weekForecast.Humidity)
					break
				case 7:
					utils.ConvertStringToIntAndAppendToSlice(item.Text()[0:len(item.Text())-1], &weekForecast.ChanceOfRain)
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
