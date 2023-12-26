package dao;

import entity.User;

import java.util.List;

public interface IUser {
    public int Ajouter(User u);
    public List<User> list();
}
