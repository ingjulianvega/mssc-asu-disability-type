package ingjulianvega.ximic.msscasudisabilitytype.bootstrap;

import ingjulianvega.ximic.msscasudisabilitytype.domain.DisabilityTypeEntity;
import ingjulianvega.ximic.msscasudisabilitytype.domain.repositories.DisabilityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class DisabilityTypeLoader implements CommandLineRunner {

    private final DisabilityTypeRepository disabilityTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (disabilityTypeRepository.count() == 0) {
            loadDisabilityTypeObjects();
        }
    }

    private void loadDisabilityTypeObjects() {
        disabilityTypeRepository.saveAll(Arrays.asList(
                DisabilityTypeEntity.builder().name("Laboral temporal").build(),
                DisabilityTypeEntity.builder().name("Laboral permanente").build(),
                DisabilityTypeEntity.builder().name("Otra").build()
        ));
    }
}