package theNorthApplication.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="statistic")
public class Statistic {

    @Id
    @Column(name = "store_id")
    private String id;

    @Column(name="queue_size")
    private int queueSize;
}
