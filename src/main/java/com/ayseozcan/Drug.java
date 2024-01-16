package com.ayseozcan;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "drugs")
public class Drug {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String brand;
    @Field(type = FieldType.Text)
    private String company;
    @Field(type = FieldType.Integer)
    private Integer stock;
}
