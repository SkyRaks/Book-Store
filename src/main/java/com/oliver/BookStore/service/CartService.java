package com.oliver.BookStore.service;

import com.oliver.BookStore.model.Book;
import com.oliver.BookStore.model.Cart;
import com.oliver.BookStore.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart save(Cart cart) {
        Cart savedCartBook = cartRepository.save(cart);
        return savedCartBook;
    }

    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }
}
