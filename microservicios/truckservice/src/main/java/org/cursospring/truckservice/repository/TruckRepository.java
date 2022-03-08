package org.cursospring.truckservice.repository;

import java.util.List;

import org.cursospring.truckservice.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer> {
    List<Truck> findByCompanyId(int companyId);
}
