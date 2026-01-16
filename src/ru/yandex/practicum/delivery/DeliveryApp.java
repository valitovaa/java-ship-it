package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    public static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> trackableFragileParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(30);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(30);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(30);


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatusForTrackableParcels();
                    break;
                case 5:
                    showWhatInsideTheBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Сообщить статус для отслеживаемых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }


    private static void addParcel() {
        System.out.println("Введите тип посылки: 1 - Стандартная, 2 - Скоропортящаяся или 3 - Хрупкая");

        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите данные посылки");
        System.out.println("Описание посылки");
        String description = scanner.nextLine();
        System.out.println("Вес");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Адрес доставки");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Дата отправления");
        int sendDay = Integer.parseInt(scanner.nextLine());

        Parcel parcel;

        switch (choice) {
            case 1:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardParcelBox.addParcel((StandardParcel) parcel);
                break;
            case 2:
                System.out.println("Введите срок годности посылки");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableParcelBox.addParcel((PerishableParcel) parcel);
                break;
            case 3:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                trackableFragileParcels.add((FragileParcel) parcel);
                fragileParcelBox.addParcel((FragileParcel) parcel);
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }

        allParcels.add(parcel);
    }

    private static void sendParcels() {

        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    public static int calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int costForAllParcels = 0;
        for (Parcel parcel : allParcels) {
            costForAllParcels += parcel.calculateDeliveryCost();
        }

        System.out.println("Общая стоимость доставки всех посылок составляет: " + costForAllParcels);
        return costForAllParcels;
    }

    private static void reportStatusForTrackableParcels() {

        if(!trackableFragileParcels.isEmpty()){
            System.out.println("Введите новое местоположение для отслеживания:");
            String newLocation = scanner.nextLine();

            for (FragileParcel parcel : trackableFragileParcels) {
                parcel.reportStatus(newLocation);
            }
        }else{
            System.out.println("Хрупких посылок пока не отправляли");
        }

    }

    private static void showWhatInsideTheBox() {

        System.out.println("Введите тип коробки: 1 - Стандартная, 2 - Скоропортящаяся или 3 - Хрупкая");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                standardParcelBox.getAllParcels();
                break;
            case 2:
                perishableParcelBox.getAllParcels();
                break;
            case 3:
                fragileParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }


}



