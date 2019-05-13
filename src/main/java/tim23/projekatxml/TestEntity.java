package tim23.projekatxml;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity {

    @Id
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
