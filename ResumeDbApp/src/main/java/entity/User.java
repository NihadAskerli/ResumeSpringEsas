/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;
import java.util.List;

public class User {
    private  int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profileDescription;
    private Date birthDate;
    private Country country;
    private Country birthPlace;
    private List<UserSkill> skills;



    public User(int id) {

    this.id = id;
    }
    

    public User(int id,String name,String surname,String email,String phone,String profileDesc,Date birthDate,Country country,Country birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.country = country;
        this.birthPlace = birthPlace;
        this.profileDescription=profileDesc;
    }

    


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Country getNationality() {
        return country;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setNationality(Country country) {
        this.country = country;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", profileDescription=" + profileDescription + ", birthDate=" + birthDate + ", country=" + country + ", birthPlace=" + birthPlace + ", skills=" + skills + '}';
    }
    

}