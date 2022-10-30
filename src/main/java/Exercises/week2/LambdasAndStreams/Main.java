package Exercises.week2.LambdasAndStreams;

import Exercises.week2.LambdasAndStreams.StockService.Stock;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Stock stock = new Stock();
        stock.generateItem(10);

        System.out.println("stock's Items:");
        System.out.println(stock);
        System.out.println();

        System.out.println("Items expired dates:");
        System.out.println(stock.getExpiredItems());
        System.out.println();

        System.out.println("Closest expired date:");
        System.out.println(stock.getClosestExpiredDateItem());
        System.out.println();

        System.out.println("Stock's Items sorted Alphabetically:");
        System.out.println(stock.getItemsListSortedAlphabetically());
        System.out.println();

        String itemName = "TV";
        System.out.println("Find item by name: the name [" + itemName + "]");
        System.out.println(stock.getItemByName(itemName));
        System.out.println();

        int weight = 4;
        System.out.println("Filter item that above : [" + weight + "]");
        System.out.println(stock.filterItemByWeight(weight));
        System.out.println();

        System.out.println("Group by Type :");
        System.out.println(stock.groupingByType());
        System.out.println();

    }

}
