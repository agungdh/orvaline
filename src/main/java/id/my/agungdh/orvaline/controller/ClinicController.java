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

    public ResponseEntity<ClinicDTO> getClinic(String id) {


        return ResponseEntity.ok(null);
    }
}
