package by.daryazalevskaya.negotium.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class AuthorizationController {

    @GetMapping("/homePage")
    public String homePage(Authentication authentication) {
        Collection<? extends GrantedAuthority> granted = authentication.getAuthorities();
        granted.forEach(s-> System.out.println(s));
        return "homeEmployee";
    }
}
