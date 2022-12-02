import model.StudentsFI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_1 {

    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "12345";

    // Вызов всего, что есть в таблице (* - всё)
    private final static String select = "select *from studentsList ph";

    public static void showInfo() {

        List<StudentsFI> studentsList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка. Драйвер не найден! " + e.getMessage());
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentsFI student = new StudentsFI();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                studentsList.add(student);
            }

            System.out.println("Список студентов: ");
            studentsList.forEach(System.out::println);
            System.out.println();

        } catch (SQLException e) {
            System.out.println("Ошибка. Соединение не установлено! " + e.getMessage());
        }
    }

    public static void questions() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("Желаете добавить запись? (Да или Нет)");
            String answer1 = sc.nextLine();
            if (answer1.equals("Да") || answer1.equals("да") || answer1.equals("дА")) {
                System.out.println("Введите имя студента: ");
                String firstName = sc.nextLine();
                System.out.println("Введите фамилию студента: ");
                String lastName = sc.nextLine();
                String firstNameTB = "'" + firstName + "'";
                String lastNameTB = "'" + lastName + "'";

                // Добавление записи
                statement.executeUpdate("insert into studentsInfo(student_id, firstname, lastName) values ('19', " + firstNameTB + ", " + lastNameTB + ")");

                // Удаление записи
                System.out.println("Желаете удалить запись? (Да или Нет)");
                String answer2 = sc.nextLine();
                System.out.println("Введите id для удаления");
                int student_id = sc.nextInt();
                if (answer2.equals("Да") || answer2.equals("да") || answer2.equals("дА")) {
                    statement.executeUpdate("DELETE FROM studentsInfo WHERE student_id = " + student_id + "");
                }

            } else {
                System.out.println();
                System.out.println("Работа окончена.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}