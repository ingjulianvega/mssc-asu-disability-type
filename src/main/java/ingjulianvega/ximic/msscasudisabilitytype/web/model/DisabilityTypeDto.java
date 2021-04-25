package ingjulianvega.ximic.msscasudisabilitytype.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisabilityTypeDto implements Serializable {

    static final long serialVersionUID = 553825031314424644L;

    private UUID id;
    private String name;

}
