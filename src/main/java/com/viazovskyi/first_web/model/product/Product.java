package com.viazovskyi.first_web.model.product;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(indexName = "product_data")
@Setting(shards = 4)
@Accessors(chain = true)
public class Product {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String name;

    private double price;

    private String description;

    private String country;

    private ProductInfo productInfo;

    public double getCountedPrice (int perc) {
        return price - (price / 100 * perc);
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ProductInfo{
        @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)
        private LocalDateTime createdOn;

        @Field(type = FieldType.Keyword)
        private String createdBy;
    }
}


