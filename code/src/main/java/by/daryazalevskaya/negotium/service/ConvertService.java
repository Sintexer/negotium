package by.daryazalevskaya.negotium.service;

import java.time.LocalDate;
import java.time.Period;

public class ConvertService {

    public int countAge(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
