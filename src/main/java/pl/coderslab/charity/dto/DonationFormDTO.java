package pl.coderslab.charity.dto;

import lombok.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class DonationFormDTO {
    private Integer quantity;
    private List<Category> categories = new ArrayList<>();
    private Institution institutions;
    private Long institutionId;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    private User user;

}
