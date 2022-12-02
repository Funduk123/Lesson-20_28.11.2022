package model;

public class StudentsAddress {
    private int id;
    private String firstName;
    private String lastName;
    private String city;


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "________________________________" + "\n"
                + "Студент № " + id + "\n"
                + "Имя: " + firstName + '\n'
                + "Фамилия: " + lastName + '\n'
                + "Родной город: " + city;
    }
}