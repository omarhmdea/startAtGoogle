package main

import (
	"awesomeProject/server"
	"fmt"
)

func main() {

	//res := weatherAndRadar.WillItRain("london", 4)
	res := server.AverageTemp("france", "paris", 4)
	//res2 := weatherAtlas.Scrap("france", "paris")
	fmt.Printf("%+v\n", res)
	//fmt.Println(res2)

}
