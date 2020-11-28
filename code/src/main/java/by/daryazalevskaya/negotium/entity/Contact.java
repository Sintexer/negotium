package by.daryazalevskaya.negotium.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Contact {
    private String telephone;
    private String email;
    private String skype;
}
