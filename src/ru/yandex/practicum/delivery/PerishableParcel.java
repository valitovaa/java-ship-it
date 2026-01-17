package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    int timeToLive;
    static int fixedDeliveryPrice = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return (sendDay + timeToLive) < currentDay;

    }

    @Override
    public int getFixedDeliveryPrice() {
        return fixedDeliveryPrice;
    }

    @Override
    public String toString() {
        return "PerishableParcel{" +
                "timeToLive=" + timeToLive +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}
