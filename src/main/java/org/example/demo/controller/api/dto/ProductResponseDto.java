package org.example.demo.controller.api.dto;

import org.example.demo.repository.entity.Category;
import org.example.demo.repository.entity.Product;
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
    private final List<com.example.demo.controller.api.dto.ProductOptionResponseDto> options;

    public static ProductResponseDto from(Product entity) {
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