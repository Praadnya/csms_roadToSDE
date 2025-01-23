package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.CustomerEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
    boolean existsByEmail(String email);


}
