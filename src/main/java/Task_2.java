import model.StudentsAddress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task_2 {

    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "12345";

    // Вызов всего, что есть в таблице (* - всё)
    private final static String select = "select *from studentsInfo ph";

    public static void showInfo() {
        List<StudentsAddress> studentsAddressList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка. Драйвер не найден! " + e.getMessage());
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentsAddress student = new StudentsAddress();
                student.setId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setCity(resultSet.getString("city"));
                studentsAddressList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Ошибка. Соединение не установлено! " + e.getMessage());
        }

        System.out.println("Список студентов 2.0: ");
        studentsAddressList.forEach(System.out::println);
        System.out.println();
    }
}