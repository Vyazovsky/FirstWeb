package com.viazovskyi.first_web.dto.products;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class AdminProductDetailResponse extends CustomerProductDetailResponse{
    //private String id;
    private LocalDateTime createdOn;
    private String createdBy;

}
