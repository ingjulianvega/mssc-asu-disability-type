package ingjulianvega.ximic.msscasudisabilitytype.services;


import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityType;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityTypeDto;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityTypeList;

import java.util.UUID;

public interface DisabilityTypeService {
    DisabilityTypeList get(Boolean usingCache);

    DisabilityTypeDto getById(UUID id);

    void create(DisabilityType disabilityType);

    void updateById(UUID id, DisabilityType disabilityType);

    void deleteById(UUID id);
}
