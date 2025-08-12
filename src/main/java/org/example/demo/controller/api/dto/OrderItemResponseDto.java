//study_file
//controller DTO
//OrderItemResponseDto
package org.example.demo.controller.api.dto;

import org.example.demo.repository.entity.vo.OrderItem;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemResponseDto {
    private final Long optionId;
    private final String optionName;
    private final int quantity;
    private final long price;

    //OrderItem entity 로부터 필요한 값? 만 가져옴
    public static OrderItemResponseDto from(OrderItem entity){
        return new OrderItemResponseDto(
            entity.getOptionId(),
            entity.getOptionName(),
            entity.getQuantity(),
            entity.getPrice()
        );
    }
}
