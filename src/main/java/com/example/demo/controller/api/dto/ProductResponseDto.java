package com.example.demo.controller.api.dto;
//ProductResponseDto

import com.example.demo.repository.entity.Category;
import com.example.demo.repository.entity.Product;
import com.example.demo.repository.entity.ProductOption;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponseDto {
    private final Long id;
    private final Long vendorId;
    private final String name;
    private final String imageUrl;
    private final Category category;
    private final List<ProductOptionResponseDto> options;

    public static ProductResponseDto from(Product entity){
        return new ProductResponseDto(
            entity.getId(),
            entity.getVendorId(),
            entity.getName(),
            entity.getImageUrl(),
            entity.getCategory(),
            entity.getOptions().stream().map(ProductOptionResponseDto::from).toList()
            );
    }

}
