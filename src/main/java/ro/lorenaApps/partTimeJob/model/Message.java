package ro.lorenaApps.partTimeJob.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    //TODO: another type, larger
    private String content;

    @NotNull
    @ManyToOne
    @CreatedBy
    private User sender;

    @NotNull
    //TODO: relation
    private User receiver;

    @CreatedDate
    private ZonedDateTime sendDate;

    private Boolean read = false;

}
