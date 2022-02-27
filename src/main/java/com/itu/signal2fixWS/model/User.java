package com.itu.signal2fixWS.model;

import com.itu.signal2fixWS.util.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name="auth_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    @Email
    private String email;

    @ValidPassword
    @NotBlank
    @Column(name="motdepasse")
    private String motDePasse;

    @OneToOne
    @JoinTable(name = "chief_region",
            joinColumns = @JoinColumn(name = "iduser",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idregion",referencedColumnName = "id"))
    private Region region;

    @OneToOne
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "iduser",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idrole",referencedColumnName = "id"))
    private Role role;
}
