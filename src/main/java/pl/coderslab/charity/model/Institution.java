package pl.coderslab.charity.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Institution")
public class Institution extends AbstractEntity {
    private String name;
    private String description;

    public Institution() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
