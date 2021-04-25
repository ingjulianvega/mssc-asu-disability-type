package ingjulianvega.ximic.msscasudisabilitytype.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DisabilityTypeEntity extends BaseEntity {

    private String name;
}
