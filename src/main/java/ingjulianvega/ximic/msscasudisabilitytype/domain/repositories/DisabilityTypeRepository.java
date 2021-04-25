package ingjulianvega.ximic.msscasudisabilitytype.domain.repositories;

import ingjulianvega.ximic.msscasudisabilitytype.domain.DisabilityTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface DisabilityTypeRepository extends JpaRepository<DisabilityTypeEntity, UUID>, JpaSpecificationExecutor<DisabilityTypeEntity> {
}
