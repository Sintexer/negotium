package by.daryazalevskaya.negotium.entity.employer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vacancy")
@Getter
@Setter
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;
    private String address;
    private int minExperience;
    private String schedule;

    @ElementCollection
    private List<String> duties;

    @ElementCollection
    private List<String> requirements;

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;
}
