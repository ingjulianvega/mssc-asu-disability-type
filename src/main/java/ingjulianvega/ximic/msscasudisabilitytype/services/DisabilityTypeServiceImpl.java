package ingjulianvega.ximic.msscasudisabilitytype.services;

import ingjulianvega.ximic.msscasudisabilitytype.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasudisabilitytype.domain.DisabilityTypeEntity;
import ingjulianvega.ximic.msscasudisabilitytype.domain.repositories.DisabilityTypeRepository;
import ingjulianvega.ximic.msscasudisabilitytype.exception.DisabilityTypeException;
import ingjulianvega.ximic.msscasudisabilitytype.web.Mappers.DisabilityTypeMapper;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityType;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityTypeDto;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityTypeList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class DisabilityTypeServiceImpl implements DisabilityTypeService {

    private final DisabilityTypeRepository disabilityTypeRepository;
    private final DisabilityTypeMapper disabilityTypeMapper;

    @Cacheable(cacheNames = "disabilityTypeListCache")
    @Override
    public DisabilityTypeList get() {
        log.debug("get()...");
        return DisabilityTypeList
                .builder()
                .bodyPartList(disabilityTypeMapper.disabilityTypeEntityListToDisabilityTypeDtoList(disabilityTypeRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "disabilityTypeCache")
    @Override
    public DisabilityTypeDto getById(UUID id) {
        log.debug("getById()...");
        return disabilityTypeMapper.disabilityTypeEntityToDisabilityTypeDto(
                disabilityTypeRepository.findById(id)
                        .orElseThrow(() -> new DisabilityTypeException(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND, "")));
    }

    @Override
    public void create(DisabilityType disabilityType) {
        log.debug("create()...");
        disabilityTypeMapper.disabilityTypeEntityToDisabilityTypeDto(
                disabilityTypeRepository.save(
                        disabilityTypeMapper.disabilityTypeDtoToDisabilityTypeEntity(
                                DisabilityTypeDto
                                        .builder()
                                        .name(disabilityType.getName())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, DisabilityType disabilityType) {
        log.debug("updateById...");
        DisabilityTypeEntity evidenceEntity = disabilityTypeRepository.findById(id)
                .orElseThrow(() -> new DisabilityTypeException(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND, ""));

        evidenceEntity.setName(disabilityType.getName());

        disabilityTypeRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        disabilityTypeRepository.deleteById(id);
    }
}
