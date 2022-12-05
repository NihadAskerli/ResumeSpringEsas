package main;

import dao.inter.CountryDaoInter;
import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import entity.Country;
import entity.Skill;
import entity.User;

import java.sql.Date;


public class Main {

    public static void main(String[] args) throws Exception {

        UserDaoInter userdao = Contextnew.intstanceUserDao();
        User u = new User(16, "Niko", "Askerli", "asdshgdf", "asdjhsdh", "dsjkfd", new Date(1978 - 12 - 23), new Country(56, "asdhsd", "sdjkhsdf"), new Country(45, "adjhdf", "sdfjhd"));
        System.out.println(userdao.addUser(u));
//        System.out.println(userdao.getById(12));


    }
}