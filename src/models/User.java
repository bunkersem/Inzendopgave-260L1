package models;

/**
 * Created by Sem on 09-Jul-17.
 */
public class User {


    private static User currentUser = null;
    private static boolean isAdmin = false;

    int id;
    String name;

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
        if (currentUser.name.equalsIgnoreCase("admin")){
            isAdmin = true;
        } else {
            isAdmin = false;
        }
    }

    public static boolean isAdmin() {
        return isAdmin;
    }
    public static User getCurrentUser() {
        return currentUser;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    String email;

    public User(final int id, final String name) {
        this.id = id;
        this.name = name;
    }
}
