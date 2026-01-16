package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class ParcelBoxTest {
    @Test
    void testAddParcelWithinMaxWeight() {
        // Создаём коробку с максимальным весом
        ParcelBox<StandardParcel> box = new ParcelBox<>(100); // Предположим, максимальный вес 100 кг

        // Создаём посылку с весом, который не превышает максимальный вес коробки
        StandardParcel parcel = new StandardParcel("Описание", 50, "Адрес", 1);

        // Добавляем посылку в коробку
        box.addParcel(parcel);

        // Проверяем, что посылка была добавлена
        assertEquals(1, ((ParcelBox<StandardParcel>) box).deliveryBox.size());
    }

    @Test
    void testAddParcelExceedingMaxWeight() {
        // Создаём коробку с максимальным весом
        ParcelBox<StandardParcel> box = new ParcelBox<>(100); // Предположим, максимальный вес 100 кг

        // Создаём посылку с весом, который превышает максимальный вес коробки
        StandardParcel heavyParcel = new StandardParcel("Тяжелая посылка", 150, "Адрес", 2);

        // Пытаемся добавить посылку в коробку
        box.addParcel(heavyParcel);

        // Проверяем, что посылка не была добавлена
        assertEquals(0, box.deliveryBox.size());
    }
}
