package model;

public class StudentsFI {

    private int id;
    private String firstName;
    private String lastName;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "________________________________" + "\n"
                + "Студент № " + id + "\n"
                + "Имя: " + firstName + '\n'
                + "Фамилия: " + lastName;
    }


}
