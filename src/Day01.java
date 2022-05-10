import javax.management.Query;
import java.sql.*;

public class Day01 {

    private static final String query = "select * from students";

    public static void main(String[] args) throws SQLException {

        // step 1. establish the connection of MySQL
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_tech?useSSL=false", "root", "123456789");

        // step 2. create  a statement using that above connection object
        Statement statement = connection.createStatement();

        // step 3 execute the query. there are 2 methods for execution
            ResultSet rs = statement.executeQuery(query)){

        // step 4. process the result and execute it
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getNString("name");
            String email = rs.getNString("email");
            String country = rs.getNString("country");

            //finally, print my result
            System.out.println(id+ ", "+name + ", " + email + ", " + country);
        }

        } catch (SQLException e){
            e.printStackTrace();
        }


    }
}
