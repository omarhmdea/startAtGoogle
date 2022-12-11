package weatherAndRadar

import (
	"awesomeProject/server/constants"
	"awesomeProject/server/structs"
	"awesomeProject/server/utils"
)

func WillItRain(cityName string, days int) []int {
	utils.ValidDays(days)
	return getWeatherParameterWeatherAndRadar(cityName, "chanceOfRain", days)
}

func NextRainDay(cityName string) int {
	res := getWeatherParameterWeatherAndRadar(cityName, "chanceOfRain", constants.MAX_NUM_OF_DAYS)
	for index, value := range res {
		if value >= 50 {
			return index + 1
		}
	}
	return -1
}

func AverageTemp(cityName string, days int) float64 {
	utils.ValidDays(days)
	res := getWeatherParameterWeatherAndRadar(cityName, "max", days)

	return utils.AvgOFArray(res)
}

func TempArray(cityName string, days int) structs.Temperature[int] {
	utils.ValidDays(days)
	var temperature = structs.Temperature[int]{}

	temperature.MaxTemp = getWeatherParameterWeatherAndRadar(cityName, "max", days)
	temperature.MinTemp = getWeatherParameterWeatherAndRadar(cityName, "min", days)

	return temperature
}

func WeatherSummary(cityName string) structs.Summary[int] {
	summary := structs.Summary[int]{}
	summaryOfTheDay := ForecastForXDays(cityName, 1)

	summary.MaxTemp = utils.Round(summaryOfTheDay[0].Temperature.Max.Air)
	summary.MinTemp = utils.Round(summaryOfTheDay[0].Temperature.Min.Air)
	summary.Wind = utils.Round(utils.ConvertStringToFloat(summaryOfTheDay[0].Wind.Speed.MilesPerHour.Value))
	summary.Humidity = utils.Round(summaryOfTheDay[0].Humidity * 100)
	summary.ChanceOfRain = utils.Round(summaryOfTheDay[0].Precipitation.Probability * 100)

	return summary

}

func ForecastForXDays(cityName string, days int) structs.WeatherForecast {

	url1 := "https://api-app.wetteronline.de/search/autosuggest?application=pwa&av=2&c=cHdhOnNCcDlyQnprcHhrOTMrPWA=&language=en&name=" + cityName

	var searchRes structs.Search
	utils.GetRequestAndParesJSON(url1, &searchRes)

	url2 := "https://api-app.wetteronline.de/search/geokeycoding?application=pwa&av=2&c=cHdhOnNCcDlyQnprcHhrOTMrPWA=&geoObjectKey=" + searchRes[0].GeoObjectKey + "&language=en&region=GB"

	var searchDetails structs.MoreDetails
	utils.GetRequestAndParesJSON(url2, &searchDetails)
	locationId := searchDetails[0].ContentKeys.PollenKey.LocationID

	url3 := "https://api-app.wetteronline.de/app/weather/forecast?av=2&c=cHdhOnNCcDlyQnprcHhrOTMrPWA=&location_id=" + locationId + "&mv=12"

	var weatherForecast structs.WeatherForecast
	utils.GetRequestAndParesJSON(url3, &weatherForecast)

	return weatherForecast[0:days]
}

func getWeatherParameterWeatherAndRadar(cityName string, param string, days int) []int {
	var weekForecast = structs.Forecast{}
	var weatherForecast = ForecastForXDays(cityName, days)

	for _, value := range weatherForecast {
		utils.ConvertStringToIntAndAppendToSlice(value.Wind.Speed.MilesPerHour.Value, &weekForecast.Wind)
		utils.AppendIntToSlice(utils.Round(value.Temperature.Max.Air), &weekForecast.MaxTemp)
		utils.AppendIntToSlice(utils.Round(value.Temperature.Min.Air), &weekForecast.MinTemp)
		utils.AppendIntToSlice(utils.Round(value.Precipitation.Probability*100), &weekForecast.ChanceOfRain)
		utils.AppendIntToSlice(utils.Round(value.Humidity*100), &weekForecast.Humidity)
	}

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
