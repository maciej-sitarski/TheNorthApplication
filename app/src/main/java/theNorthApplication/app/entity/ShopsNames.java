package theNorthApplication.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shops_names")
public class ShopsNames {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "type")
    String type;
}
