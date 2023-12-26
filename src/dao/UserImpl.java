package dao;

import entity.Role;
import entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements IUser{
    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int Ajouter(User u) {

        String sql = "INSERT INTO users VALUES (?,?,?,?)";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, u.getEmail());
            db.getPstm().setString(2, u.getPassword());
            db.getPstm().setString(3, u.getPasswordHashed());

            Role role = u.getId();
            int RoleId;
            if(role != null){
                RoleId = role.getId();
                db.getPstm().setInt(4,RoleId);
            }

            ok = db.executeMaj();
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<User> list() {
        List<User> user = new ArrayList<>();
        String sql = "SELECT * FROM users u  JOIN role r ON u.id = r.id";

        try{
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()){
                User users = new User();
                users.setId_user(rs.getInt("u.id_user"));
                users.setEmail(rs.getString("u.email"));
                Role role = new Role();
                role.setId(rs.getInt("r.id"));
                role.setName(rs.getString("r.name"));
                users.setId(role);
                user.add(users);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // Retourner la liste d'utilisateurs
        return user;
        }
        //return null;
    public int ExistRole(){
        int RoleExist = 1;
        String sql = "SELECT id FROM role WHERE ID=2";
        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            if (rs.next()){
                RoleExist = rs.getInt("id");
            }
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return RoleExist;
    }
}
