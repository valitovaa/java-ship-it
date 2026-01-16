package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.DeliveryApp;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {
    private DeliveryApp deliveryApp;

    @BeforeEach
    void setUp() {
        deliveryApp = new DeliveryApp();
        // Здесь можно добавить посылки в список allParcels для тестирования
    }

    @Test
    void testCalculateCosts() {
        // Добавляем посылки с известной стоимостью доставки
        DeliveryApp.allParcels.add(new StandardParcel("Описание", 10, "Адрес", 1));
        DeliveryApp.allParcels.add(new PerishableParcel("Описание", 5, "Адрес", 2, 3));
        DeliveryApp.allParcels.add(new FragileParcel("Описание", 8, "Адрес", 4));

        // Рассчитываем общую стоимость доставки
        int totalCost = DeliveryApp.calculateCosts();
        int expectedTotalCost = 20 + 15 + 24;

        // Проверяем, что расчёт верен
        assertEquals(expectedTotalCost, totalCost); // Здесь expectedTotalCost — ожидаемая общая стоимость
    }
}
