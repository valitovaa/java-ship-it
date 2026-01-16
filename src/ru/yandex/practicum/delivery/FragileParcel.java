package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    static int fixedDeliveryPrice = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + this.description + " обёрнута в защитную плёнку");
        System.out.println("Посылка " + this.description + " упакована");

    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + this.description + " изменила местоположение на " + newLocation);
    }
}
