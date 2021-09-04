package com.connected.cars.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consumer implements Serializable {

    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "DOB cannot be null")
    private LocalDate dob;

    @NotNull(message = "Salary cannot be null")
    private Double salary;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private Long age;

}
