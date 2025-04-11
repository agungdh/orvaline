package id.my.agungdh.orvaline.service;

import id.my.agungdh.orvaline.dto.ClinicDTO;
import id.my.agungdh.orvaline.entity.Clinic;
import id.my.agungdh.orvaline.exception.NotFoundException;
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

    public ClinicDTO update(Clinic clinic, ClinicDTO clinicDTO) {
        clinicMapper.updateEntityFromDTO(clinicDTO, clinic);
        clinicRepository.save(clinic);

        return clinicMapper.toDto(clinic);
    }

    public void delete(Clinic clinic) {
        clinicRepository.delete(clinic);
    }

    public ClinicDTO getClinic(Clinic clinic) {
        return clinicMapper.toDto(clinic);
    }

    public Clinic getClinicOrThrow(String id) {
        return clinicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Clinic with id " + id + " not found"));
    }
}
