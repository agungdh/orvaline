package id.my.agungdh.orvaline.mapper;

import id.my.agungdh.orvaline.dto.ClinicDTO;
import id.my.agungdh.orvaline.entity.Clinic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClinicMapper {
    List<ClinicDTO> toDTOList(List<Clinic> clinics);

    ClinicDTO toDto(Clinic clinic);

    Clinic toClinic(ClinicDTO clinicDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ClinicDTO dto, @MappingTarget Clinic entity);
}
