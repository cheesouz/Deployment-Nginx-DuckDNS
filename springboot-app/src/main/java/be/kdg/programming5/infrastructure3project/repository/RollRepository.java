package be.kdg.programming5.infrastructure3project.repository;

import be.kdg.programming5.infrastructure3project.domain.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollRepository extends JpaRepository<Roll, Long> {
}
