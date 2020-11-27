package by.daryazalevskaya.negotium.entity.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class JobPreference {
    private String desiredPosition;
    private int salary;

    private String schedule;
}
