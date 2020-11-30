package by.daryazalevskaya.negotium.entity.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
@Data
public class JobPreference {
    private String desiredPosition;
    private int salary;

    private String schedule;
}
