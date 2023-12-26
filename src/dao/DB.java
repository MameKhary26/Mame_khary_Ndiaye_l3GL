package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstm;
    private int ok;

    private void  getConnection(){
        String host = "localhost";
        String database = "gestion_utils";
        int port = 3306;
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connexion reussie !");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void initPrepar(String sql ){
        try {
            getConnection();
            pstm = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ResultSet executeSelect(){
        rs = null;
        try {
            rs = pstm.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    public void closeConnection(){
        try {
            if(conn != null)
                conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }
}
