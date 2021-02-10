package com.matthewwerth.crudweek.repository;

import com.matthewwerth.crudweek.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
