package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import ru.yandex.practicum.delivery.PerishableParcel;


public class PerishableParcelTest {
    @Test
    void testIsExpired() {
        // Создаём посылку со сроком годности 3 дня
        PerishableParcel parcel = new PerishableParcel("Описание", 5, "Адрес", 1, 3);

        // Проверяем, что посылка ещё не испортилась
        assertFalse(parcel.isExpired(3));

        // Проверяем, что посылка испортилась
        assertTrue(parcel.isExpired(6));
    }
}
