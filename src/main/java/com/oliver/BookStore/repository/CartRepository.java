package com.oliver.BookStore.repository;

import com.oliver.BookStore.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
