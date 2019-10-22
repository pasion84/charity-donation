package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.coderslab.charity.model.Category;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class DonationFormDTO {
    private Integer quantity;
    private List<Category> categories = new ArrayList<>();
    private Long institutionId;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

}
