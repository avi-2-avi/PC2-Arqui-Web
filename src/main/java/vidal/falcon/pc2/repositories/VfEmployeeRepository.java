package vidal.falcon.pc2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vidal.falcon.pc2.entities.VfEmployee;

public interface VfEmployeeRepository extends JpaRepository<VfEmployee, Long> {
}
