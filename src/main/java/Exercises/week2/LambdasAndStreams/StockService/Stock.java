package Exercises.week2.LambdasAndStreams.StockService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Stock {

    private final List<Item> itemsList;


    public Stock() {
        this.itemsList = new ArrayList<>();
    }


    public Stock(List<Item> itemsLis) {
        this.itemsList = itemsLis;
    }


    public void generateItem(int amount) {

        for(int i = 0; i < amount; i++) {
            itemsList.add(Objects.requireNonNull(Item.createRandomItem()));
        }
        itemsList.sort(Item::compareTo);
    }


    public List<Item> getExpiredItems() {
        return itemsList.stream().filter((item) -> item.getExpirationDate().isBefore(LocalDate.now())).collect(Collectors.toList());
    }


    public Item getClosestExpiredDateItem() {
        return itemsList.get(0);
    }


    public List<Item> getItemsListSortedAlphabetically() {
        return itemsList.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());
    }


    public Item getItemByName(String name) {
        return itemsList.stream().filter(item -> item.getName().equals(name)).reduce((f, s) -> f).orElse(null);
    }


    public List<String> filterItemByWeight(int weight) {
        return itemsList.stream().filter(item -> item.getWeight() > weight).map(Item::getName).collect(Collectors.toList());
    }


    public Map<ProductType, Long> groupingByType() {
        return itemsList.stream().collect(Collectors.groupingBy(Item::getType, Collectors.counting()));
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Items: \n");
        for(Item item : itemsList) {
            str.append(item.toString()).append("\n");
        }
        return str.toString();
    }


}
