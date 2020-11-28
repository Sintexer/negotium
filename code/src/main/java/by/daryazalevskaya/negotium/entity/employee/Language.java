package by.daryazalevskaya.negotium.entity.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Language {
    private String languageName;
    private String level;
}
