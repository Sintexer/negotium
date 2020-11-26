package by.daryazalevskaya.negotium.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Contact {
    private String telephone;
    private String email;
    private String skype;
}
