package by.daryazalevskaya.negotium.entity.employer;

import by.daryazalevskaya.negotium.entity.Contact;
import by.daryazalevskaya.negotium.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

    public Employer (User user) {
        this.user=user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;
    private String taxPayerNumber;
    private String country;
    private String city;
    private Contact contact;

    @OneToMany(mappedBy = "employer")
    private List<Vacancy> vacancies=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public void addVacancy(Vacancy vacancy) {
        vacancies.add(vacancy);
    }


}
