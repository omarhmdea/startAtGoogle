package types

import "awesomeProject/server/structs"

type Number interface {
	int | float64
}

type Wrapper interface {
	structs.Search | structs.MoreDetails | structs.WeatherForecast
}
