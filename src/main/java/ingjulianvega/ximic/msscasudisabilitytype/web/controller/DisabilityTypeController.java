package ingjulianvega.ximic.msscasudisabilitytype.web.controller;


import ingjulianvega.ximic.msscasudisabilitytype.services.DisabilityTypeService;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityType;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityTypeDto;
import ingjulianvega.ximic.msscasudisabilitytype.web.model.DisabilityTypeList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DisabilityTypeController implements DisabilityTypeI {

    private final DisabilityTypeService disabilityTypeService;

    @Override
    public ResponseEntity<DisabilityTypeList> get() {
        return new ResponseEntity<>(disabilityTypeService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DisabilityTypeDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(disabilityTypeService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid DisabilityType disabilityType) {
        disabilityTypeService.create(disabilityType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid DisabilityType disabilityType) {
        disabilityTypeService.updateById(id, disabilityType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        disabilityTypeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
