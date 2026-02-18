package com.example.demo.repository.entity;

import com.example.demo.repository.entity.vo.CartItem;
//import lombok.*; //왜.. 다 가져 오는거지..
import java.util.ArrayList;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@ToString

public class Cart extends AggregateRoot{
    @Setter
    private Long id;
    private final Long customerId;
    private final List<CartItem> itmes = new ArrayList<>();

    public Cart(Long customerId) { this.customerId = customerId; }

    public void addProduct(Product product, ProductOption option, int quantity) {
        if (option.getStock() < quantity) {
            throw new IllegalStateException("상품의 재고가 부족하여 장바구니에 담을 수 없습니다");
        }
        //이미 장바주니에 담겨 있는 상품&옵션인지 확인하는 영역
        itmes.stream()
            .filter(item -> item.getProductId().equals(product.getId()) && item.getOptionId().equals(option.getId()))
            .findFirst()
            .ifPresentOrElse(
                item -> itme.increaseQuantity(quantity), //있으면 같은 상품 수량 증가
                () -> itmes.add(new CartItem(product, option, quantity)) //없으면 없는 상품 새로 추가
            );
    }

    pubilc long calculateTotalPrice(){
        return  itmes.stream().mapToLong(CartItem::calculatePrice).sum();
    }
}
