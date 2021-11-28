package ru.mephi.seminar6.classwork;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static ru.mephi.seminar6.classwork.ShoppingCart.deserialize;

class Item implements Serializable {
    int id;
    String description;
    double cost;

    Item(int id, String description, double cost) {
        this.id = id;
        this.cost = cost;
        this.description = description;
    }
}

class ShoppingCart implements Serializable {
    transient private static int count = 0;

    int cartID;
    ArrayList<Item> items;
    int itemCount;
    transient double cartTotal;

    ShoppingCart() {
        cartID = count++;
        itemCount = 0;
        items = new ArrayList<>();
        cartTotal = 0;
    }

    void put(Item something) {
        items.add(something);
        itemCount++;
        cartTotal += something.cost;
    }

    void print() {
        System.out.println("Total: " + cartTotal);
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items.get(i).description);
        }
    }

    public void serialize(String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(this);
        } catch (IOException e) {
            System.out.println("Exception write: " + e);
        }
    }

    public static ShoppingCart deserialize(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            ShoppingCart cart = (ShoppingCart) in.readObject();
            for (int i = 0; i < cart.itemCount; i++) {
                cart.cartTotal += cart.items.get(i).cost;
            }
            return cart;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception write: " + e);
        }
        return null;
    }
}


public class task2 {

    static Random rand = new Random();
    static Item[] descriptions = new Item[]{
            new Item(1, "Blouse", 50),
            new Item(2, "Shirt", 25),
            new Item(3, "Pants", 15),
            new Item(4, "Breeches", 19),
            new Item(5, "Leggings", 49),
            new Item(6, "Jeans", 100),
            new Item(7, "Shorts", 30),
            new Item(8, "Skirt", 45),
            new Item(9, "Linen", 34),
            new Item(10, "Shoes", 20),
            new Item(11, "Hats", 100),
            new Item(12, "Dresses", 50),
            new Item(13, "Outerwear", 55),
            new Item(14, "Shorts", 30)
    };

    public static void take(ShoppingCart myCard) {
        myCard.put(descriptions[Math.abs(rand.nextInt() % descriptions.length)]);
    }

    public static void take(String description, ShoppingCart myCard) {
        for (Item item : descriptions) {
            if (item.description.equals(description)) {
                myCard.put(item);
            }
        }
    }

    public static void main(String[] args) {

        ShoppingCart myCart = new ShoppingCart();

        int count = Math.abs(rand.nextInt() % 20);
        for (int i = 0; i < count; i++) {
            take(myCart);
        }


        myCart.serialize("./src/ru/mephi/seminar6/classwork/date.txt");

        ShoppingCart myCart1 = deserialize("./src/ru/mephi/seminar6/classwork/date.txt");

        if (myCart1 != null)
            myCart1.print();
    }

}

