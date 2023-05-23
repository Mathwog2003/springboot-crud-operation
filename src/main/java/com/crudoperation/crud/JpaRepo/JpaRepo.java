package com.crudoperation.crud.JpaRepo;

import com.crudoperation.crud.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<Registration,Integer> {
}
