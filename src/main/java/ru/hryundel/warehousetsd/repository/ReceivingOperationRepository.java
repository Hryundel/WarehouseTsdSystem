package ru.hryundel.warehousetsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hryundel.warehousetsd.model.ReceivingOperation;

public interface ReceivingOperationRepository extends JpaRepository<ReceivingOperation, Long> {}
