package com.store.car.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDTO {

    @NotBlank(message = "cannot be blank")
    @Min(value = 3, message = "should be greater than 3")
    @Max(value = 100, message = "should be less than 100")
    private String model;

    @NotBlank(message = "cannot be blank")
    @Pattern(regexp = "GM|FIAT|FORD", message = "Should be GM, FIAT or FORD")
    private String brand;

    @NotBlank(message = "cannot be blank")
    private Double price;

    @NotBlank(message = "cannot be blank")
    private String description;

    @NotBlank(message = "cannot be blank")
    private String engineVersion;

    @NotBlank(message = "cannot be blank")
    private String city;

    @NotBlank(message = "cannot be blank")
    private String createdDate;

    @NotBlank(message = "cannot be blank")
    private Long ownerId;

    @NotBlank(message = "cannot be blank")
    private String ownerName;

    @NotBlank(message = "cannot be blank")
    private String ownerType;

    @NotBlank(message = "cannot be blank")
    @Size(max = 100, message = "Should be up to 100 characters")
    private String contact;
}
