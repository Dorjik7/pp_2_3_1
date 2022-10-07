package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")

    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "age")
    private int age;
    @Column(name = "email")

    private String email;

    public User() {
    }

    public User(String name, String secondName, int age, String email) {

        this.firstName = name;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", second_name='" + secondName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}





