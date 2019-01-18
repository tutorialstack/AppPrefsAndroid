package in.tutorialstack.appprefs;

import java.io.Serializable;

public class UserModel implements Serializable {
    int Id;
    String FirstName;
    String LastName;
    String Avatar;

    public void setId(int id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAvatar() {
        return Avatar;
    }
}