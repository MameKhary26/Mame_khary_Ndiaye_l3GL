package entity;

import dao.IUser;
import dao.PasswordHashing;
import dao.UserImpl;
import entity.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    private int id_user;
    private String email;
    private String password;
    private String passwordHashed;
    private Role id;

    public User() {
    }

    public User(int id_user, String email, String password, String passwordHashed, int id) {
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.passwordHashed = passwordHashed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHashed() {
        return passwordHashed;
    }

    public void setPasswordHashed(String passwordHashed) {
        this.passwordHashed = passwordHashed;
    }
    public void add(){

        User user = new User();
        UserImpl iuser = new UserImpl();
        Scanner scan = new Scanner(System.in);
        PasswordHashing passwordHasheds = new PasswordHashing();
        System.out.println("Donner l'email du user");
        email = scan.nextLine();
        System.out.println("Donner le mot de passe");
        password = scan.nextLine();
        passwordHashed = passwordHasheds.generatePasswordHash(password,"1234567890ABCDEF" );
        System.out.println("User cree avec succes");
        this.id = user.getId();
        int RoleId = iuser.ExistRole();
        if(RoleId != 1){
            Role rl = new Role();
            rl.setId(RoleId);
            user.setId(rl);
        }
        setEmail(email);
        setPassword(password);
        setPasswordHashed(passwordHashed);

    }

    public String generateEmail(){
        String email;
        Scanner scan = new Scanner(System.in);
        System.out.println("Donner votre email");
        email = scan.nextLine();
        return email;
    }

    public static boolean validEmail(String email){
        String emailVal = ".@gmail.com";
        return Pattern.matches(emailVal, email);
    }

    public Role  getId() {
        return id;
    }

    public void setId(Role  id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
