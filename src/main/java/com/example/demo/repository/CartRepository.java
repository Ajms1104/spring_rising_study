package com.example.demo.repository;

import com.example.demo.repository.entity.Cart;
import com.example.demo.repository.entity.Order;
import com.example.demo.repository.entity.Product;

import com.example.demo.repository.ports.ICart_RepositoryPort;
import com.example.demo.repository.ports.IOder_RepositoryPort;

import java.util.Map;
import org.springframework.stereotype.Repository; //★★★

import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@RequiredArgsConstructor

public class CartRepository implements ICart_RepositoryPort {
    private final Map<Long, Cart> Store = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Optional<Cart> findByCustomerId(Long CustomerId){
        return store.values().stream().filter((each)->customerId.equals(each.getCustomerId())).findFirst();
    }

    @Override
    public Cart save(Cart cart){
        if (cart.getId() == null){
            long generatedId = sequence.incrementAndGet();
            cart.setId(generatedId);
        }
        store.put(cart.getId(), cart);
        return store.get(cart.getId());
    }
}
