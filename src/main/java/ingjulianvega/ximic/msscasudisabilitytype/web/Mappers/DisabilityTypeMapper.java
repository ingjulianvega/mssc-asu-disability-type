package ingjulianvega.ximic.msscasudisabilitytype.web.Mappers;


import ingjulianvega.ximic.msscasudisabilitytype.domain.DisabilityTypeEntity;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityTypeDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface DisabilityTypeMapper {
    DisabilityTypeDto disabilityTypeEntityToDisabilityTypeDto(DisabilityTypeEntity disabilityTypeEntity);

    DisabilityTypeEntity disabilityTypeDtoToDisabilityTypeEntity(DisabilityTypeDto disabilityTypeDto);

    ArrayList<DisabilityTypeDto> disabilityTypeEntityListToDisabilityTypeDtoList(List<DisabilityTypeEntity> disabilityTypeEntitiesTypeEntityList);
}
