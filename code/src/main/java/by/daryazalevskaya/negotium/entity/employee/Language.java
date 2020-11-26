package by.daryazalevskaya.negotium.entity.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Language {
    private String languageName;
    private String level;
}
