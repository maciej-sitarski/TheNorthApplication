package theNorthApplication.app.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@Table(name = "statistic")
public class Statistic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "queue_size")
    @Max(value = 3)
    @Min(value = 0)
    private Integer queueSize;
}
