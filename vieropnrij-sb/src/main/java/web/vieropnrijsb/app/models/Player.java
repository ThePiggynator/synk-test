package web.vieropnrijsb.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Player {
    @Id
    private long id;
    private String color;
}
