package id.my.agungdh.orvaline.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record ClinicDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String id,
        @NotBlank
        String name,
        String description,
        @NotBlank
        String token
) { }
