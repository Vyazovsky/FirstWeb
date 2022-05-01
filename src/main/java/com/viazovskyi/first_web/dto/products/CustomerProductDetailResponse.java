package com.viazovskyi.first_web.dto.products;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CustomerProductDetailResponse extends ProductResponseDto {
    private String description;
    private String country;

}
