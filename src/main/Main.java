package main;

import dao.DB;
import dao.IUser;
import dao.UserImpl;
import entity.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        User user = new User();
        int choice;
        do {
            System.out.println("Menu : ");
            System.out.println("1- Ajouter un utilisateur");
            System.out.println("2- Lister les utilisateurs");
            System.out.println("Faites votre choix");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    IUser userdao = new UserImpl();
                    user.add();
                    break;

                case 2:
                    IUser userdao2 = new UserImpl();
                    List<User> users = userdao2.list();
                    for (User u : users){
                        System.out.println("Email : " + u.getEmail() +
                                "Role : " + u.getId().getName()+ "Mot de Passe : " + u.getPassword());
                    }
                    break;
            }

        }while(choice<1 || choice>2);

    }
}