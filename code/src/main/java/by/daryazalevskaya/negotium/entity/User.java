package by.daryazalevskaya.negotium.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usr")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    @ElementCollection(targetClass = SecurityRole.class, fetch = FetchType.LAZY)
//    @CollectionTable(name = "authority", joinColumns = @JoinColumn(name = "user_id_auth"))
//    @Enumerated(EnumType.STRING)
//    @Getter
//    @Setter
//    private Set<SecurityRole> authorities;
//
//    protected String username;
//    protected String password;
//
//    private boolean active;






    @Enumerated(EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    // @NotNull
    @Getter
    @Setter
    private String username;

    // @NotNull
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private boolean isActive;

    @ElementCollection(targetClass = SecurityRole.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id_role"))
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Set<SecurityRole> roles;
}
