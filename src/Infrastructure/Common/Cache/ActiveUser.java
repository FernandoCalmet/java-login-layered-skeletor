package Infrastructure.Common.Cache;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 */
public class ActiveUser {

    public static int c_id;
    public static String c_name;
    public static String c_email;
    public static String c_password;

    public static int getId() {
        return c_id;
    }

    public static void setId(int c_id) {
        ActiveUser.c_id = c_id;
    }

    public static String getName() {
        return c_name;
    }

    public static void setName(String c_name) {
        ActiveUser.c_name = c_name;
    }

    public static String getEmail() {
        return c_email;
    }

    public static void setEmail(String c_email) {
        ActiveUser.c_email = c_email;
    }

    public static String getPassword() {
        return c_password;
    }

    public static void setPassword(String c_password) {
        ActiveUser.c_password = c_password;
    }
}
