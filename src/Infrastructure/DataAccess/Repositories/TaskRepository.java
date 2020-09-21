package Infrastructure.DataAccess.Repositories;

import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Abstracts.ITaskRepository;
import Support.Entities.TaskEntity;
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
public class TaskRepository extends Repository implements ITaskRepository, IGenericRepository<TaskEntity> {

    @Override
    public TaskEntity add(TaskEntity entity) {
        try {
            String query = "INSERT INTO tasks (id, name, description, status, userId, createdAt) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getDescription());
            statement.setInt(4, entity.getStatus());
            statement.setInt(5, entity.getUserId());
            statement.setString(6, entity.getCreatedAt());
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
    public TaskEntity edit(TaskEntity entity) {
        try {
            String query = "UPDATE tasks SET name = ? , description = ?, status = ?, updatedAt = ? WHERE id = ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getDescription());
            statement.setInt(3, entity.getStatus());
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
            String query = "DELETE FROM tasks WHERE id = ? ";
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
    public Iterable<TaskEntity[]> getAll() {
        List<TaskEntity[]> listTask = null;

        try {
            String query = "SELECT id, name, description, status, userId FROM tasks ORDER BY id";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listTask = new ArrayList<>();
            while (result.next()) {
                TaskEntity[] taskEntity = new TaskEntity[meta.getColumnCount()];
                for (int i = 0; i < taskEntity.length; i++) {
                    taskEntity[i] = (TaskEntity) result.getObject(i + 1);
                }
                listTask.add(taskEntity);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listTask;
    }

    @Override
    public Iterable<TaskEntity[]> getByValue(String value) {
        List<TaskEntity[]> listTask = null;

        try {
            String query = "SELECT id, name, description, status, userId WHERE name LIKE ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listTask = new ArrayList<>();
            while (result.next()) {
                TaskEntity[] taskEntity = new TaskEntity[meta.getColumnCount()];
                for (int i = 0; i < taskEntity.length; i++) {
                    taskEntity[i] = (TaskEntity) result.getObject(i + 1);
                }
                listTask.add(taskEntity);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listTask;
    }
}
