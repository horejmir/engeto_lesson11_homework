package com.engeto;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GoodsMethods goods = new GoodsMethodsImpl();

        Item newItem1 = new Item("SNB3422", "SNB96", "snowboard N2 160cm",
                "model year 2022, freestyle", 3, new BigDecimal(9800));
        Item newItem2 = new Item("SNB3423", "SNB97", "snowboard N3 164cm",
                "model year 2022, split", 0, new BigDecimal(22800));
        Item newItem3 = new Item("SNB3421", "SNB98", "snowboard N1 156cm",
                "model year 2022, allround", 4, new BigDecimal(9800));
        Item newItem4 = new Item("SNB3421", "SNB99", "snowboard N1 160cm",
                "model year 2022, allround", 15, new BigDecimal(9800));
        Item newItem5 = new Item("SNB3421", "SNB99", "snowboard N1 160cm",
                "model year 2022, allround", 15, new BigDecimal(9800));

        goods.saveItem(newItem1);
        goods.saveItem(newItem2);
        goods.saveItem(newItem3);
        goods.saveItem(newItem4);
        goods.saveItem(newItem5);
        goods.saveItem(null);

        System.out.println("List of all items:");
        List<Item> items = goods.loadAllAvailableItems();
        items.forEach(System.out::println);

        Integer itemId =  1;

        goods.updatePrice(itemId,new BigDecimal(8400.00));

        System.out.println("Item with id: " + itemId);
        System.out.println(goods.loadItemById(itemId));

        goods.deleteAllOutOfStockItems();

    }
}
