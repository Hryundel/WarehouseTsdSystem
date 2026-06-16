package ru.hryundel.warehousetsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hryundel.warehousetsd.model.StockCell;
import java.util.Optional;

public interface StockCellRepository extends JpaRepository<StockCell, Long> {
    Optional<StockCell> findByCode(String code);
}
