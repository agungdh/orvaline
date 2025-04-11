package id.my.agungdh.orvaline.controller;

import id.my.agungdh.orvaline.dto.ClinicDTO;
import id.my.agungdh.orvaline.entity.Clinic;
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
        Clinic clinic = clinicService.getClinicOrThrow(id);
        return ResponseEntity.ok(clinicService.getClinic(clinic));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicDTO> update(@PathVariable String id, @RequestBody @Valid ClinicDTO clinicDTO) {
        Clinic clinic = clinicService.getClinicOrThrow(id);
        ClinicDTO updatedClinic = clinicService.update(clinic, clinicDTO);
        return ResponseEntity.ok(updatedClinic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Clinic clinic = clinicService.getClinicOrThrow(id);
        clinicService.delete(clinic);
        return ResponseEntity.noContent().build();
    }
}
