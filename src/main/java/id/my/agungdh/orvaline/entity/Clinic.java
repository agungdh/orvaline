package id.my.agungdh.orvaline.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Clinic {
    @Id
    private String id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String token;
}
