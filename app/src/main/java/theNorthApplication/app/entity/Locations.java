package theNorthApplication.app.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "locations")
public class Locations {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "town")
    private String town;

    @Column(name = "province")
    private String province;


}
