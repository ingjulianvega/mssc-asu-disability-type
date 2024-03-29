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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class DisabilityTypeServiceImpl implements DisabilityTypeService {

    private final DisabilityTypeRepository disabilityTypeRepository;
    private final DisabilityTypeMapper disabilityTypeMapper;

    @Cacheable(cacheNames = "disabilityTypeListCache", condition = "#usingCache == false")
    @Override
    public DisabilityTypeList get(Boolean usingCache) {
        log.debug("get()...");
        return DisabilityTypeList
                .builder()
                .bodyPartList(disabilityTypeMapper.disabilityTypeEntityListToDisabilityTypeDtoList(disabilityTypeRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "disabilityTypeCache")
    @Override
    public DisabilityTypeDto getById(UUID id) {
        log.debug("getById()...");
        return disabilityTypeMapper.disabilityTypeEntityToDisabilityTypeDto(
                disabilityTypeRepository.findById(id)
                        .orElseThrow(() -> DisabilityTypeException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_SOLUTION)
                                .build()));
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
                .orElseThrow(() -> DisabilityTypeException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.DISABILITY_TYPE_NOT_FOUND_SOLUTION)
                        .build());

        evidenceEntity.setName(disabilityType.getName());

        disabilityTypeRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        disabilityTypeRepository.deleteById(id);
    }
}
