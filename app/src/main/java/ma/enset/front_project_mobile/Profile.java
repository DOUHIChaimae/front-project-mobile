package ma.enset.front_project_mobile;

public class Profile {
    private String name;
    private String email;
    private String bio;

    public Profile(String name, String email, String bio) {
        this.name = name;
        this.email = email;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }
}
