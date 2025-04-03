package id.my.agungdh.orvaline.service;

import id.my.agungdh.orvaline.dto.ClinicDTO;
import id.my.agungdh.orvaline.entity.Clinic;
import id.my.agungdh.orvaline.mapper.ClinicMapper;
import id.my.agungdh.orvaline.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicMapper clinicMapper;
    private final ClinicRepository clinicRepository;

    public List<ClinicDTO> index() {
        List<Clinic> clinics = clinicRepository.findAll();

        return clinicMapper.toDTOList(clinics);
    }

    public ClinicDTO create(ClinicDTO clinicDTO) {
        Clinic clinic = clinicMapper.toClinic(clinicDTO);

        clinicRepository.save(clinic);

        return clinicMapper.toDto(clinic);
    }
}
