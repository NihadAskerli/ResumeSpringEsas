
package dao.impl;

import entity.Country;
import entity.User;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDesc=rs.getString("profile_description");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");
        

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthPlaceStr, null);
       return new User(id,name,surname,phone,email,profileDesc,birthdate,nationality,birthplace);
    }
    private User getUserSimple(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDesc=rs.getString("profile_description");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        Date birthdate = rs.getDate("birthdate");



        return new User(id,name,surname,phone,email,profileDesc,birthdate,null,null);
    }
    @Override
    public List<User> getAll(String name,String surname,Integer nationalityId) {
        List<User> result = new ArrayList<>();
        try ( Connection c = connect()) {


            String sql="SELECT"
                    + "\tu.*,"
                    + "\tn.nationality,"
                    + "\tc.nationality AS birthplace "
                    + "FROM"
                    + "\tUSER u"
                    + "\tLEFT JOIN country n ON u.nationality_id = n.id "
                    + "\tLEFT JOIN country c on u.birthplace_id=c.id where 1=1";
            if(name!=null && ! name.trim().isEmpty()){
                sql+=" and u.name=? ";
            }
            if(surname!=null && ! surname.trim().isEmpty()){
                sql+=" and u.surname=?";
            }
            if(nationalityId!=null){
                sql+=" and u.nationality_id=?";
            }
            PreparedStatement stmt = c.prepareStatement(sql);
            int i=1;
            if(name!=null&& ! name.trim().isEmpty()){
                stmt.setString(i,name);
                i++;
            }
            if(surname!=null && ! surname.trim().isEmpty()){
                stmt.setString(i,surname);
                i++;
            }
            if(nationalityId!=null){
                stmt.setInt(i,nationalityId);
            }
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
            System.out.println(c.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int userId) {
        User result=null;
        try ( Connection c = connect()) {

            PreparedStatement stmt =c.prepareStatement ("SELECT"
                    + "\tu.*,"
                    + "\tn.nationality,"
                    + "\tc.nationality AS birthplace "
                    + "FROM"
                    + "\tUSER u"
                    + "\tLEFT JOIN country n ON u.nationality_id = n.id "
                    + "\tLEFT JOIN country c on u.birthplace_id=c.id where u.id=?");


            stmt.setInt(1,userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result = getUser(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        //Class.forName("com.mysql.jdbc.Driver");

        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,phone=?,email=?,profile_Description=?,birthdate=?,birthplace_id=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDescription());
            stmt.setDate(6, u.getBirthDate());
                        stmt.setInt(7, u.getBirthPlace().getId());

            stmt.setInt(8, u.getId());
            return stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addUser(User u) {

        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(id,name,surname,email,phone,profile_Description) values(?,?,?,?,?,?)");
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getName());
            stmt.setString(3, u.getSurname());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getPhone());
            stmt.setString(6, u.getProfileDescription());

            return stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {

        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("delete from user where id=?");
            stmt.setInt(1, id);
            return stmt.execute();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
