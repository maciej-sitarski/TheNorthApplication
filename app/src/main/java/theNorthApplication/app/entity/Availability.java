//package theNorthApplication.app.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//
//@Entity
//@Data
//@Table(name="availability")
//public class Availability {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name="mask_availability")
//    @Max(value = 3)
//    @Min(value = 0)
//    private Integer maskAvailability;
//
//    @Column(name="gloves_availability")
//    @Max(value = 3)
//    @Min(value = 0)
//    private Integer glovesAvailability;
//
//    @Column(name="gel_availability")
//    @Max(value = 3)
//    @Min(value = 0)
//    private Integer gelAvailability;
//
//    @OneToOne(mappedBy = "availability")
//    private Availability availability;
//}
