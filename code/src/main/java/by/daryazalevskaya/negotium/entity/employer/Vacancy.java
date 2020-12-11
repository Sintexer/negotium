package by.daryazalevskaya.negotium.entity.employer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="vacancy")
@Data
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String position;

    private String city;
    private String address;
    private int minExperience;
    private String schedule;

    private String duties;

    private String requirements;

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;
}
