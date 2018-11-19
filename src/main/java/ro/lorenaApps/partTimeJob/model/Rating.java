package ro.lorenaApps.partTimeJob.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer score;

    //TODO: maybe longer
    private String description;

    @NotNull
    @ManyToOne
    private User writer;

    //TODO: mappings
    @NotNull
    @ManyToOne
    private User owner;


}
