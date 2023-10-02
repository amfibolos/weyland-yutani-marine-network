package wy.mn.ns.marinemanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wy.mn.ns.marinemanagementservice.entity.Marine;

import java.util.Optional;

public interface MarineRepository extends JpaRepository<Marine, Long> {

    Optional<Marine> findByEmail(String email);

}
