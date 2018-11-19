package ro.lorenaApps.partTimeJob.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ro.lorenaApps.partTimeJob.enums.JobDomain;
import ro.lorenaApps.partTimeJob.enums.JobStatus;
import ro.lorenaApps.partTimeJob.enums.TimeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue
    private Long id;

    /*sumar al serviciului*/
    @NotNull
    private String jobTitle;

    //TODO: probabil ar trebui sa folosesc alt tip de data, in care sa intre mai multe caractere
    /*descriere ampla a serviciului*/
    private String jobDescription;

    /*timpul estimat necesar de lucru*/
    private Integer estimatedTime;

    /*unitatea de masura in care este introdus timpul*/
    @Enumerated(EnumType.STRING)
    private TimeType timeType;

    //TODO: make some hours per day: full 8, more (+ value), part :4, less (+ value), does not matter

    @Enumerated(EnumType.STRING)
    private Set<JobDomain> jobDomains;

    /*data la care s-a publicat anuntul*/
    @CreatedDate
    private ZonedDateTime createdDate;

    /*data la care s-a publicat anuntul*/
    @LastModifiedDate
    private ZonedDateTime lastModifiedDate;

    /*data de la care se necesita inceperea job-ului*/
    private ZonedDateTime startDate;

    /*data pana la care serviciul trebuie terminat*/
    private ZonedDateTime endDate;

    @ManyToOne
    @CreatedBy
    private User createdBy;

    private Double revenuePerHour;

    //TODO: calculated automatically
    @Transient
    private Double revenuePerJob;

    //TODO: connection table
    @ManyToMany
    private List<User> interestedUsers;

    private Integer viewsCount;

    private Boolean workFromHome = false;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

}
