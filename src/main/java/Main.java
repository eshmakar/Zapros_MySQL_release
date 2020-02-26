import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите запрос MySQL");
            String query = scanner.nextLine();

            try {
                Statement statement = worker.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));

                    System.out.println(user);
                }
                System.out.println();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}