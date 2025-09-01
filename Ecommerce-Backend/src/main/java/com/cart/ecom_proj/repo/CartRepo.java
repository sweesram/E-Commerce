package com.cart.ecom_proj.repo;

import com.cart.ecom_proj.model.Cart;
import com.cart.ecom_proj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
    Optional<Cart> findByUserAndProductId(User user, Integer productId);
    void deleteByUserAndProductId(User user, Integer productId);
    void deleteByUser(User user);
}
