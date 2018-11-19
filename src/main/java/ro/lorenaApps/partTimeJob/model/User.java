package ro.lorenaApps.partTimeJob.model;

import lombok.Data;
import ro.lorenaApps.partTimeJob.enums.UserType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    //TODO: store profile picture / use facebook
    //private Blob picture;

    //TODO: when not unique, write info message in UI
    @Column(unique = true)
    @NotNull
    private String username;

    private String password;

    /*define what your capabilities are, or even experience*/
    private String personalDescription;

    //TODO: when not unique, write message + password forgotten option
    @Email
    @NotNull
    @Column(unique = true)
    private String eMail;

    //TODO: validation
    @Column(unique = true)
    private String phoneNr;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;

    //TODO: should it be different ratings, when a user is both contrator and worker!?

    @OneToMany
    private List<Rating> ratings;

    //TODO: transient or not!?
    private Double ratingScore;

    @OneToMany
    private List<Message> inboxMessages;

}
