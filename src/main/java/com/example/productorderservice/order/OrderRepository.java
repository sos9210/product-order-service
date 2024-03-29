package com.example.productorderservice.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
