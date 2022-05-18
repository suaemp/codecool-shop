package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

//    List<Supplier> findAll();
//    Optional<Supplier> findById(int id);
//
//    void save(Supplier supplier);
//    void deleteById(int id);

}
