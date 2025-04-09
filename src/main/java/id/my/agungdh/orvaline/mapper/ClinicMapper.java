package id.my.agungdh.orvaline.mapper;

import id.my.agungdh.orvaline.dto.ClinicDTO;
import id.my.agungdh.orvaline.entity.Clinic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClinicMapper {
    ClinicMapper INSTANCE = Mappers.getMapper(ClinicMapper.class);

    List<ClinicDTO> toDTOList(List<Clinic> clinics);

    ClinicDTO toDto(Clinic clinic);

    Clinic toClinic(ClinicDTO clinicDTO);
}
