package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "donations")
public class Donation extends AbstractEntity {
    private Integer quantity;
    @ManyToMany
    private List<Category> categories = new ArrayList<>();
    @OneToOne
    private Institution institutions;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "pick_up_date")
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;
    @Column(name = "pick_up_comment")
    private String pickUpComment;
}
