package abm.javafxtemplate.dao.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.PersistenceCreator;

@Entity
@Table(name = "users", catalog = "app")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @PersistenceCreator
    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserEntity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
