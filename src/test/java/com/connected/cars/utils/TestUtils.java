package com.connected.cars.utils;

import com.connected.cars.domain.Consumer;

import java.time.LocalDate;

public class TestUtils {

    private TestUtils() {

    }

    public static Consumer getConsumer() {
        return Consumer.builder()
                .id(1L)
                .age(18L)
                .dob(LocalDate.now())
                .name("test")
                .build();
    }
}
