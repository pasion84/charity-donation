package pl.coderslab.charity.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Institution")
public class Institution extends AbstractEntity {
    private String name;
    private String description;

    public Institution() {
    }

}
