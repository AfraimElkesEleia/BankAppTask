public class Admin {
private String name;
private String password;

    public Admin(String name, String password) {
        this.name = name;
        if(password.length()>=8)
            this.password = password;
        else
            System.out.println("Enter password bigger than 8 characters");
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
