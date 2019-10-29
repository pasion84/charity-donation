package pl.coderslab.charity.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@NoArgsConstructor
public class Role extends AbstractEntity {
    private String name;
}
