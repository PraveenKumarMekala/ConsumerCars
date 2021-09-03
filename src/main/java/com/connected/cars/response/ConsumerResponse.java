package com.connected.cars.response;

import com.connected.cars.domain.Consumer;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumerResponse {

    private List<Consumer> consumers;
}
