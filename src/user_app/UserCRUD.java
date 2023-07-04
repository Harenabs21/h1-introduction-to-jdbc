package user_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserCRUD {
    // insert a user
    public static void insertUser(int id, String name, String email, String password){
        /**
         * Devoir : faites en sorte que le CRUD marche
         * - Trouvez un moyen pour qu'on n'utilise plus qu'une SEULE instance de
         * Connection, et une SEULE instance de Statement dans TOUTE l'application.
         * Pour cela, regardez le DESIGN PATTERN : SINGLETON.
         */
    }

    // find a single user by its id
    // en JPA vous auriez juste écrit : public User findById(int id);
    public static User findUserById(int id){
        ConnectionToDatabase db = new ConnectionToDatabase();
        Connection connection = db.createConnection();

        try{
            Statement statement = connection.createStatement();
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
