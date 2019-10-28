package pl.coderslab.charity.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "institutions")
public class Institution extends AbstractEntity {
    private String name;
    private String description;
}
