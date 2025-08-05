package com.example.demo.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@Getter //클래스에 적용
@ToString

public class Product extends AggregateRoot {
    @Setter //필드에 적용

    //멤버 변수 선언
    private Long id; //Long : Null 값을 가질 수 있음
    private final Long vendorId; //final : 값이 정해지면 변경 될 수 없음
    private final String name;
    private final String imageUrl;
    private final Category category;
    private final List<ProductOption> options;

    public Product(Long vendorId, String name, String imageUrl, Category category, List<ProductOption> options) {
        this.vendorId = vendorId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.options = options;

    }
    public boolean hasStock() {return options.stream().anyMatch(ProductOption option -> option.getStock()>0);}

    public boolean isAvailable(Long optionId, int quantity) {
        return getOptionById(optionId)
            .map(ProductOption option -> option.getStock() >=quantity)
            .orElse(other:false);
    }


    public boolean isAvailable(Long optionId, int quantity) {
        getOptionByID(optionId)
            .ifpresent(ProductOption option -> {
                if (option.getStock()<quantity){
                    throw new  IllegalStateException("재고가 부족합니다.");
                }
                option.decreaseStock(quantity);
            });
    }

    public  Optional<ProductOption> getOptionById(Long optionId) {
        return options.stream()
            .filter(ProductOption o -> o.getId().equals(optionId))
            .findFirst();
    }
}
