package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    static int fixedDeliveryPrice = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getFixedDeliveryPrice() {
        return fixedDeliveryPrice;
    }

}
