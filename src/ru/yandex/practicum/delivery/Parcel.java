package ru.yandex.practicum.delivery;

public abstract class Parcel {

    protected final String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;



    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + this.description + " упакована");

    }

    public void deliver() {
        System.out.println("Посылка " + this.description + " доставлена по адресу " + this.deliveryAddress);
    }

    public int calculateDeliveryCost() {
        int price = getFixedDeliveryPrice();
        return this.weight * price;
    }

    public abstract int getFixedDeliveryPrice();

    @Override
    public String toString() {
        return "Parcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}
