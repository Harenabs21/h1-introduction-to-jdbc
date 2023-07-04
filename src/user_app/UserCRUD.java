package user_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserCRUD {
    // insert a user
    public static void insertUser(int id, String name, String email, String password){

    }

    // find a single user by its id
    public static User findUserById(int id){
        ConnectionToDatabase db = new ConnectionToDatabase();
        Connection connection = db.createConnection();

        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"user\" WHERE id = "+id;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
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
