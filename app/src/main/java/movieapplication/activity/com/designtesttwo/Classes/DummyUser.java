package movieapplication.activity.com.designtesttwo.Classes;

/**
 * Created by hanaa mohamed on 05-Oct-15.
 */
public class DummyUser {
    String userName;
    int avatar;
    String type;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DummyUser(int avatar, String type, String userName) {

        this.avatar = avatar;
        this.type = type;
        this.userName = userName;
    }
}
