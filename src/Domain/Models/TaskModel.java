package Domain.Models;

import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Repositories.TaskRepository;
import Support.Entities.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class TaskModel {
    private int _id;
    private String _name;
    private String _description;
    private int _status;
    private int _userId;
    private String _createdAt;
    private String _updatedAt;
    private IGenericRepository genericRepository;

    public TaskModel() {
        this.genericRepository = new TaskRepository();
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int _status) {
        this._status = _status;
    }

    public int getUserId() {
        return _userId;
    }

    public void setUserId(int _userId) {
        this._userId = _userId;
    }

    public String getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(String _createdAt) {
        this._createdAt = _createdAt;
    }

    public String getUpdatedAt() {
        return _updatedAt;
    }

    public void setUpdatedAt(String _updatedAt) {
        this._updatedAt = _updatedAt;
    }

    private TaskEntity taskEntity() {
        TaskEntity taskObject = new TaskEntity();
        taskObject.setId(_id);
        taskObject.setName(_name);
        taskObject.setDescription(_description);
        taskObject.setStatus(_status);
        taskObject.setUserId(_userId);

        return taskObject;
    }

    public List<TaskModel> getAllTasks() {
        Iterable<TaskEntity> result = this.genericRepository.getAll();
        List<TaskModel> taskModelList = new ArrayList<>();

        for (TaskEntity item : result) {
            TaskModel taskModel = new TaskModel();
            taskModel.setId(item.getId());
            taskModel.setName(item.getName());
            taskModel.setDescription(item.getDescription());
            taskModel.setStatus(item.getStatus());
            taskModel.setUserId(item.getUserId());
            taskModelList.add(taskModel);
        }

        return taskModelList;
    }

    public List<TaskModel> getATaskByValue(String value) {
        Iterable<TaskEntity> result = this.genericRepository.getByValue(value);
        List<TaskModel> taskModelList = new ArrayList<>();

        for (TaskEntity item : result) {
            TaskModel taskModel = new TaskModel();
            taskModel.setId(item.getId());
            taskModel.setName(item.getName());
            taskModel.setDescription(item.getDescription());
            taskModel.setStatus(item.getStatus());
            taskModel.setUserId(item.getUserId());
            taskModelList.add(taskModel);
        }

        return taskModelList;
    }
}
