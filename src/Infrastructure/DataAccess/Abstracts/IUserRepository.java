package Infrastructure.DataAccess.Abstracts;

public interface IUserRepository {
    boolean login(String user, String pass);
}
