package id.my.agungdh.orvaline.repository;

import id.my.agungdh.orvaline.entity.Clinic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClinicRepository extends MongoRepository<Clinic, String> {
    Optional<Clinic> findByToken(String token);

    boolean existsByToken(String token);
}
