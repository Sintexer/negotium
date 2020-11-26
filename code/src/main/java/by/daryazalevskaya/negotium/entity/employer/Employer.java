package by.daryazalevskaya.negotium.entity.employer;

import by.daryazalevskaya.negotium.entity.Contact;
import by.daryazalevskaya.negotium.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employer")
@Getter
@Setter
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;
    private String taxPayerNumber;
    private String country;
    private String city;
    private Contact contact;

    @OneToMany(mappedBy = "employer")
    private List<Vacancy> vacancies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


}
