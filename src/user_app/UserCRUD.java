package user_app;

import java.sql.*;
import java.util.List;

public class UserCRUD {
     private static DatabaseSingleton database = DatabaseSingleton.getInstance();
    // insert a user
    public static void insertUser(int id, String name, String email, String password){
        Statement statement = database.getStatement();
        String sql = "INSERT INTO \"user\" VALUES (" + id + ", '" + name + "', '" + email + "', '" + password + "')";
        try{
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println(rowsAffected+" line affected");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    // find a single user by its id
    // en JPA vous auriez juste écrit : public User findById(int id);
    public static User findUserById(int id){
        Statement statement = database.getStatement();
        try{
            String sql = "SELECT * FROM \"user\" WHERE id = "+id;
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null; // il n'y a pas d'utilisateur avec cet id
    }

    // find all users
    public static List<User> findAllUsers(){
        return null;
    }

    // update a user
    public static void updateUser(int id, String newName, String newEmail, String newPassword){}

    // delete a user using its ID
    public static void deleteUser(int id){}
}
