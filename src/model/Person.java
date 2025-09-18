package model;

public abstract class Person {
    private String lastName;
    private String firstName;
    private String email;
    private String password;

    public Person(String last_name, String first_name, String password)
    {
        this.lastName = last_name;
        this.firstName = first_name;
        this.password = password;
    }

    public String getLastName()
    {
        return lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getEmail()
    {
        return email;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }


    public abstract void displayMenu();
}
