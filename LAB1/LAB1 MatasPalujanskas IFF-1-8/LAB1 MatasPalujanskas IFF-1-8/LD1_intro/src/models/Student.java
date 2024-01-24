package models;

public class Student  {
    private String firstName;
    private String lastName;
    private int age;
    private String group;

    public Student(){}

    public Student(String firstName, String lastName, int age, String group){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int GetAge()
    {
        return age;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString(){
        return String.format("%s %s age: %d group: %s", firstName, lastName, age, group);
    }

    @Override
    public boolean equals(Object student) {
        if (student == null)
            return false;

        return ((Student) student).firstName.equals(this.firstName) && ((Student) student).lastName.equals(this.lastName);
    }
}
