package com.oliver.BookStore.controller;

import com.oliver.BookStore.model.Book;
import com.oliver.BookStore.model.Cart;
import com.oliver.BookStore.service.BookService;
import com.oliver.BookStore.service.CartService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class BookController {

    private final BookService bookService;
    private final CartService cartService;

    public BookController(BookService bookService, CartService cartService) {
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/create-book")
    public String getCreatePage() {
        return "create-book";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/save-book")
    public String saveBook(@Valid Book book) {
        bookService.save(book);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/available-books";
    }

    @GetMapping("/available-books")
    public String getAvailableBooks() {
        return "available-books";
    }

    @GetMapping("/cart")
    public String getCart() {
        return "cart";
    }


    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") Long id) {
        Book book = bookService.findById(id);
        Cart cart = new Cart(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getPrice());
        cartService.save(cart);
        return "redirect:/available-books";
    }

    @GetMapping("/remove/{id}")
    public String deleteFromCart(@PathVariable("id") Long id) {
        cartService.deleteById(id);
        return "redirect:/cart";
    }

    @ModelAttribute("books")
    public Iterable<Book> getBooks() {
        return bookService.findAll();
    }

    @ModelAttribute("cart")
    public Iterable<Cart> getCartBooks() {
        return cartService.findAll();
    }

    @ModelAttribute
    public Book getBook() {
        return new Book();
    }
}
