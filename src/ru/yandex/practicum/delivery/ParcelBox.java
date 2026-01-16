package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    int maxWeight;
    int currentWeight = 0;


    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public ArrayList<T> deliveryBox = new ArrayList<>();

    public void addParcel(T parcel) {
        if ((parcel.weight + this.currentWeight) <= this.maxWeight) {
            deliveryBox.add(parcel);
            currentWeight += parcel.weight;
            System.out.println("Посылка " + parcel.description + " добавлена в коробку");
        } else {
            System.out.println("Превышен максимальный вес коробки, положите эту посылку в другую");
        }
    }

    public void getAllParcels() {
        System.out.println(" В коробке лежат посылки:");
        for (T parcel : deliveryBox) {
            System.out.println(parcel.toString());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
