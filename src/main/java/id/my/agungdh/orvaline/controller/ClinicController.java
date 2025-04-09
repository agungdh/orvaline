package id.my.agungdh.orvaline.controller;

import id.my.agungdh.orvaline.dto.ClinicDTO;
import id.my.agungdh.orvaline.entity.Clinic;
import id.my.agungdh.orvaline.mapper.ClinicMapper;
import id.my.agungdh.orvaline.service.ClinicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor
public class ClinicController {
    private final ClinicService clinicService;

    @GetMapping
    public ResponseEntity<List<ClinicDTO>> index() {
        return ResponseEntity.ok(clinicService.index());
    }

    @PostMapping
    public ResponseEntity<ClinicDTO> create(@RequestBody @Valid ClinicDTO clinicDTO) {
        return ResponseEntity.ok(clinicService.create(clinicDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicDTO> getClinic(@PathVariable String id) {
        Optional<Clinic> clinic = clinicService.getClinicEntity(id);

        return clinic.map(value -> ResponseEntity.ok(clinicService.getClinic(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Optional<Clinic> clinic = clinicService.getClinicEntity(id);

        if (clinic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        clinicService.delete(clinic.get());

        return ResponseEntity.noContent().build();
    }
}
