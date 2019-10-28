package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories")
public class Category extends AbstractEntity {

    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Donation> donations = new ArrayList<>();
}
