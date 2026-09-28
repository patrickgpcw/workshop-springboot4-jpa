package com.patrick.workshopspringboot4jpa.repositories;

import com.patrick.workshopspringboot4jpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
