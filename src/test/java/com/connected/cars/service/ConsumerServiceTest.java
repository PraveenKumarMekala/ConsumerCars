package com.connected.cars.service;

import com.connected.cars.controller.ConsumerController;
import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.provider.BaseProvider;
import com.connected.cars.response.ConsumerResponse;
import com.connected.cars.utils.TestUtils;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ConsumerServiceTest {

    @Mock
    private BaseProvider provider;

    @InjectMocks
    private ConsumerService service;

    @Test
    public void should_save_consumer_details() {
        // Given
        val consumer = TestUtils.getConsumer();
        Mockito.when(provider.saveConsumer(consumer, FileType.CSV)).thenReturn(1L);
        // When
        val id = service.save(consumer, FileType.CSV);
        // Then
        Assertions.assertEquals(id, 1L);
    }

    @Test
    public void should_fetch_all_consumer_details() {
        // Given
        val consumer = TestUtils.getConsumer();
        List<Consumer> list = new ArrayList<>();
        list.add(consumer);
        Mockito.when(provider.getAllConsumers()).thenReturn(ConsumerResponse.builder().consumers(list).build());
        // When
        val consumers = service.getAllConsumers();
        // Then
        Assertions.assertEquals(consumers.getConsumers(), list);
    }

    @Test
    public void should_update_consumer_details() {
        // Given
        val consumer = TestUtils.getConsumer();
        Mockito.when(provider.updateConsumer(1L)).thenReturn(consumer);
        // When
        val result = service.updateConsumer(1L);
        // Then
        Assertions.assertEquals(result, consumer);
    }
}
