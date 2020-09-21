package Infrastructure.DataAccess.Repositories;

import Infrastructure.Common.Cache.ActiveUser;
import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Abstracts.IUserRepository;
import Support.Entities.UserEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 */
public class UserRepository extends Repository implements IUserRepository, IGenericRepository<UserEntity> {

    @Override
    public UserEntity add(UserEntity entity) {
        try {
            String query = "INSERT INTO users (id, name, email, password, createdAt) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getCreatedAt());
            int result = statement.executeUpdate();
            if (result == 0) {
                entity = null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return entity;
    }

    @Override
    public UserEntity edit(UserEntity entity) {
        try {
            String query = "UPDATE users SET name = ? , email = ?, password = ?, updatedAt = ? WHERE id = ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getPassword());
            statement.setString(4, entity.getUpdatedAt());
            statement.setInt(5, entity.getId());
            int result = statement.executeUpdate();
            if (result == 0) {
                entity = null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return entity;
    }

    @Override
    public boolean remove(int id) {
        boolean response = false;

        try {
            String query = "DELETE FROM users WHERE id = ? ";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result > 0) {
                response = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }

    @Override
    public Iterable<UserEntity[]> getAll() {
        List<UserEntity[]> listUser = null;

        try {
            String query = "SELECT id, name, email FROM users ORDER BY id";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listUser = new ArrayList<>();
            while (result.next()) {
                UserEntity[] userEntity = new UserEntity[meta.getColumnCount()];
                for (int i = 0; i < userEntity.length; i++) {
                    userEntity[i] = (UserEntity) result.getObject(i + 1);
                }
                listUser.add(userEntity);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listUser;
    }

    @Override
    public Iterable<UserEntity[]> getByValue(String value) {
        List<UserEntity[]> listUser = null;

        try {
            String query = "SELECT id, name, email WHERE email LIKE ? OR name LIKE ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listUser = new ArrayList<>();
            while (result.next()) {
                UserEntity[] userEntity = new UserEntity[meta.getColumnCount()];
                for (int i = 0; i < userEntity.length; i++) {
                    userEntity[i] = (UserEntity) result.getObject(i + 1);
                }
                listUser.add(userEntity);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listUser;
    }

    @Override
    public boolean login(String user, String pass) {
        boolean response = false;

        try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                ActiveUser.setId(result.getInt("id"));
                ActiveUser.setName(result.getString("name"));
                ActiveUser.setEmail(result.getString("email"));
                ActiveUser.setPassword(result.getString("password"));
                response = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }
}
