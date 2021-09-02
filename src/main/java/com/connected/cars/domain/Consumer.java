package com.connected.cars.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consumer {

    private Long id;

    private String name;

    private LocalDate dob;

    private Double salary;

    private Long age;

}
