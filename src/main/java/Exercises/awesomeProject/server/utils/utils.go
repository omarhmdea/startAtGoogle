package utils

import (
	"awesomeProject/server/constants"
	"awesomeProject/server/types"
	"encoding/json"
	"github.com/PuerkitoBio/goquery"
	"io/ioutil"
	"log"
	"math"
	"net/http"
	"strconv"
)

func GetRequest(url string) *goquery.Document {
	resp, err := http.Get(url)

	if err != nil {
		log.Fatal(err)
	}
	defer resp.Body.Close()

	doc, err := goquery.NewDocumentFromReader(resp.Body)

	if err != nil {
		log.Fatal(err)
	}
	return doc
}

func GetRequestAndParesJSON[T any](url string, structObj T) {
	resp, err := http.Get(url)
	if err != nil {
		log.Fatalln(err)
	}
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Fatalln(err)
	}

	err1 := json.Unmarshal([]byte(body), &structObj)
	if err1 != nil {
		log.Fatalln(err1)
	}
}

func ConvertStringToInt(str string) int {
	toInt, _ := strconv.Atoi(str)
	return toInt
}

func ConvertStringToIntAndAppendToSlice(str string, res *[]int) {
	toInt := ConvertStringToInt(str)
	*res = append(*res, toInt)
}

func AppendIntToSlice(num int, res *[]int) {
	*res = append(*res, num)
}

func AvgOFArray[T types.Number](nums []T) float64 {
	var total T
	for _, x := range nums {
		total += x
	}
	return float64(total)
}

func AverageOf3Elements[T types.Number](e1, e2, e3 T) float64 {
	return AvgOFArray([]T{e1, e2, e3})

}

func CalcArraysAvg(arr1, arr2, arr3 []int) []float64 {
	var res []float64
	for index, _ := range arr1 {
		res = append(res, AverageOf3Elements(arr1[index], arr2[index], arr3[index]))
	}
	return res
}

func ValidDays(days int) {
	if days < 0 || days > constants.MAX_NUM_OF_DAYS {
		log.Fatal("days must be non-negative")
	}
}

func ConvertStringToFloat(str string) float64 {
	res, err := strconv.ParseFloat(str, 64)
	if err != nil {
		log.Fatal(err)
	}
	return res
}

func Round(x float64) int {
	return int(math.Floor(x + 0.5))
}
