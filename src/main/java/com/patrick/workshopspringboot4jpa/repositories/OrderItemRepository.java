package com.patrick.workshopspringboot4jpa.repositories;

import com.patrick.workshopspringboot4jpa.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
