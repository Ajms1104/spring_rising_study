//study_file controller
// 특정 고객의 주문을 조회 후 응답용 DTO로 변환, JSON 형태로 보냄
package org.example.demo.controller.api;

import org.example.demo.controller.api.dto.OrderResponseDto;
import org.example.demo.repository.entity.Order;
import org.example.demo.service.usecases.IPurchaseOrderUseCase;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IPurchaseOrderUseCase orderService;
    private static final  Long MOCK_CUSTOMER_ID = 1L;

    //Http Get 요청 처리하는 컨트롤러
    @GetMapping("")
    @ResponseBody //매서드의 반환값을 HTTP 응답의 본문으로 직렬화해서 반환
    public ResponseEntity<List<OrderResponseDto>> orderStatus() {
        List<Order> retrieved = orderService.getOrders(MOCK_CUSTOMER_ID);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(retrieved.stream().map(OrderResponseDto::from).toList());
    }
}
