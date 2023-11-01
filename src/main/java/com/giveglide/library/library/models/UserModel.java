package com.giveglide.library.library.models;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.giveglide.library.library.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Document(collection = "users")
@Data
@NoArgsConstructor
public class UserModel implements UserDetails {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;

    private String email ;

    private String firstName;

    private String lastName;

    private Number age;

    private String gender ;

    private Boolean guestCheckout;


    private Boolean verified;

    private String password;

    private String passwordResetToken;

    private Integer verificationCode;

    private String loginToken;

    private String profileImage;

    private Role role;

    public UserModel(
            ObjectId _id,
            String firstName,
            String lastName,
            String email,
            String password ,
            Role role,
            String gender,
            Number age ,
            Boolean guestCheckout,
            String passwordResetToken,
            String profileImage,
            Integer verificationCode,
            Boolean verified) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.age = age;
        this.guestCheckout=guestCheckout;
        this.passwordResetToken = passwordResetToken;
        this.profileImage = profileImage;
        this.verified = verified;
        this.verificationCode = verificationCode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public void setRole(Role role){
        this.role = role;

    }

    public void setUserGuestCheckout(Boolean guestCheckout){
        this.guestCheckout = guestCheckout;
    }

    public void setVerificationCode(Integer verificationCode ){ this.verificationCode = verificationCode; }

    public Role getRole(){
        return role;
    }

    public String getId(){
        return _id.toString();
    }

    public void setVerified(){ this.verified = true ; this.verificationCode = null;}

}
