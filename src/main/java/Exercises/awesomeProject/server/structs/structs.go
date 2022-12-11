package structs

import "time"

type Forecast struct {
	MaxTemp, MinTemp, Wind, ChanceOfRain, Humidity []int
}

type Summary[T any] struct {
	MaxTemp, MinTemp, Humidity, Wind, ChanceOfRain T
}

type Temperature[T any] struct {
	MaxTemp, MinTemp []T
}

type Search []struct {
	GeoObjectKey string `json:"geoObjectKey"`
}

type MoreDetails []struct {
	ContentKeys struct {
		PollenKey struct {
			LocationID string `json:"location_id"`
		} `json:"pollenKey"`
	} `json:"contentKeys"`
}

type WeatherForecast []struct {
	Date          time.Time `json:"date"`
	Humidity      float64   `json:"humidity"`
	Precipitation struct {
		Probability float64 `json:"probability"`
	} `json:"precipitation"`
	Temperature struct {
		Max struct {
			Air      float64 `json:"air"`
			Apparent float64 `json:"apparent"`
		} `json:"max"`
		Min struct {
			Air      float64 `json:"air"`
			Apparent float64 `json:"apparent"`
		} `json:"min"`
	} `json:"temperature"`
	Wind struct {
		Speed struct {
			MilesPerHour struct {
				Value string `json:"value"`
			} `json:"miles_per_hour"`
		} `json:"speed"`
	} `json:"wind"`
}
