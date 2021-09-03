package com.connected.cars.controller;

import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.response.ConsumerResponse;
import com.connected.cars.service.ConsumerService;
import com.connected.cars.utils.TestUtils;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ConsumerControllerTest {

    @Mock
    private ConsumerService service;

    private ConsumerController controller;

    @Before
    public void setUp() {
        controller = new ConsumerController(service);
    }

    @Test
    public void should_return_http_status_as_created_and_created_id_when_save_call_is_performed() {
        // Given
        val consumer = TestUtils.getConsumer();
        Mockito.when(service.save(consumer, FileType.CSV)).thenReturn(1L);
        // When
        val response = controller.store(TestUtils.getConsumer(), FileType.CSV);
        // Then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertEquals(response.getBody().longValue(), 1L);
    }

    @Test
    public void should_return_http_status_as_ok_and_created_id_when_fetch_call_is_performed() {
        // Given
        List<Consumer> list = new ArrayList<>();
        val consumer = TestUtils.getConsumer();
        list.add(consumer);
        Mockito.when(service.getAllConsumers()).thenReturn(
                ConsumerResponse
                        .builder()
                        .consumers(list)
                        .build());
        // When
        val response = controller.consumers();
        // Then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().getConsumers(), list);
    }

    @Test
    public void should_update_existing_consumer_based_on_id() {
        // Given
        val consumer = TestUtils.getConsumer();
        consumer.setAge(11L);
        Mockito.when(service.updateConsumer(1L)).thenReturn(consumer);
        // When
        val response = controller.updateExistingCoustmer(1L);
        // Then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), consumer);
    }
}
