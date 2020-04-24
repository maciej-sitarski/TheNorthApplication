package theNorthApplication.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="store")
public class Store {

    @Id
    @Column(name = "store_id")
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "availability_id", unique = true)
    private Availability availability;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", unique = true)
    private Statistic statistic;

}
