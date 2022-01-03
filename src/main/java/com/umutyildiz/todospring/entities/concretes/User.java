package com.umutyildiz.todospring.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.umutyildiz.todospring.core.CustomAnnotations.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","todoList"})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;


    @NotBlank
    private String userPassword;


    @NotBlank
    private String fName;


    @NotBlank
    private String surName;

    @UniqueEmail
    @Email
    @NotBlank
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Todo> todoList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_user");
    }

    @Override
    public String getPassword() {
        return getUserPassword();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
