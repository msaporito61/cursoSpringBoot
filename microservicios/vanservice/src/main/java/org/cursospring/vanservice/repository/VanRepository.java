
package org.cursospring.vanservice.repository;

import java.util.List;

import org.cursospring.vanservice.entity.Van;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VanRepository extends JpaRepository<Van, Integer> {
    List<Van> findByCompanyId(int companyId);
}
