package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class InstitutionFormDTO {
    private String name;
    private String description;
}
