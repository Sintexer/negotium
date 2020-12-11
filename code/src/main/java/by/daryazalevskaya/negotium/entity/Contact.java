package by.daryazalevskaya.negotium.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Contact {
    private String telephone;
    private String email;
    private String skype;
}
