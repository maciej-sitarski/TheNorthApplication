package theNorthApplication.app.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="availability")
public class Availability {

    @Id
    @Column(name = "store_id")
    private String id;

    @Column(name="mask_availability")
    private int maskAvailability;

    @Column(name="gloves_availability")
    private int glovesAvailability;

    @Column(name="gel_availability")
    private int gelAvailability;
}
