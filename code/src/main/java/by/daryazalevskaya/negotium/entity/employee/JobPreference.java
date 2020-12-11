package by.daryazalevskaya.negotium.entity.employee;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class JobPreference {
    private String desiredPosition;
    private int salary;

    private String schedule;
}
