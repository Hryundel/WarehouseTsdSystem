package ru.hryundel.warehousetsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hryundel.warehousetsd.model.Product;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByBarcode(String barcode);
}
