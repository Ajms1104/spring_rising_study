package com.example.demo.controller.api.dto;
//OrderResponseDto

import com.example.demo.repository.entity.vo.OrderItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponseDto {
    private final Long optionId;
    private final String optionName;
    private final int quantity;
    private final long price;

    public static OrderItemReponseDto from(OrderItem entity){
        return new OrderItemReponseDto(
            entity.getOptionId(),
            entity.getOptionName(),
            entity.getQuantity(),
            entity.getPrice()
        );
    }

}
