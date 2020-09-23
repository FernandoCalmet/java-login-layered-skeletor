package Infrastructure.Common.Cache;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 */
public class ActiveUser {

    public static int c_id;
    public static String c_username;
    public static String c_firstName;
    public static String c_email;
    public static String c_password;
    public static String c_role;

    public static int getId() {
        return c_id;
    }

    public static void setId(int id) {
        ActiveUser.c_id = id;
    }

    public static String getUsername() {
        return c_username;
    }

    public static void setUsername(String username) {
        ActiveUser.c_username = username;
    }

    public static String getFirstName() {
        return c_firstName;
    }

    public static void setFirstName(String name) {
        ActiveUser.c_firstName = name;
    }

    public static String getEmail() {
        return c_email;
    }

    public static void setEmail(String email) {
        ActiveUser.c_email = email;
    }

    public static String getPassword() {
        return c_password;
    }

    public static void setPassword(String password) {
        ActiveUser.c_password = password;
    }

    public static String getRole() {
        return c_role;
    }

    public static void setRole(String role) {
        ActiveUser.c_role = role;
    }
}
