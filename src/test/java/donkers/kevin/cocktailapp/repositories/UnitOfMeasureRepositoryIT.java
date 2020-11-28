package donkers.kevin.cocktailapp.repositories;

import donkers.kevin.cocktailapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

    @DataJpaTest
    public class UnitOfMeasureRepositoryIT {

        @Autowired
        UnitOfMeasureRepository unitOfMeasureRepository;

        @BeforeEach
        public void setUp() throws Exception {
        }

        @Test
        public void findByDescription() throws Exception {

            Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

            assertEquals("Teaspoon", uomOptional.get().getDescription());
        }

        @Test
        public void findByDescriptionMl() throws Exception {

            Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("ml");

            assertEquals("ml", uomOptional.get().getDescription());
        }

    }