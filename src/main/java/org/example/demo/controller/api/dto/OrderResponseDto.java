//study_file
//controller DTO
//OrderResponseDto
// 주문 항목 정보를 외부로 응답하기 위한 DTO
package org.example.demo.controller.api.dto;

import org.springframework.core.annotation.Order;
import org.example.demo.repository.entity.vo.OrderStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponseDto {
    private final Long id;
    private final Long customerId;
    private final String recipient;
    private final String address;
    private final String phone;
    private final OrderStatus status;
    private final List<OrderItemResponseDto> orderItems;
    private final long originalPrice;
    private final long discountedPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime orderDate;

    public static OrderResponseDto from(Order entity) {
        return new OrderResponseDto(
            entity.getId(),
            entity.getCustomerId(),
            entity.getOriginalPrice(),
            entity.getDiscountedPrice(),
            entity.getStatus(),
            entity.getOrderDate(),
            entity.getShippingInfo().getRecipient(),
            entity.getShippingInfo().getAddress(),
            entity.getShippingInfo().getPhone(),
            entity.getOrderItems().stream().map(OrderItemResponseDto::from).toList()
        );

    }

}
