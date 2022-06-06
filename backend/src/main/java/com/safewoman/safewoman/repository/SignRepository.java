package com.safewoman.safewoman.repository;

import com.safewoman.safewoman.entities.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignRepository extends JpaRepository<Sign, String> {
Optional<Sign> findByCpf(String cpf);
Optional<Sign> findByEmail(String email);
}
