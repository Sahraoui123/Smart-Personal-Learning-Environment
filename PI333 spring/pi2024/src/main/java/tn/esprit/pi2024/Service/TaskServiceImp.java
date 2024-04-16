package tn.esprit.pi2024.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.esprit.pi2024.Entity.Task;
import tn.esprit.pi2024.Repository.TaskRepo;

import java.util.List;

@Service
public class TaskServiceImp implements ITaskService {
    @Autowired
    TaskRepo taskRepo;


    public List<Task> retrieveAllTasks() {
        return taskRepo.findAll();
    }
    public Task retrieveTask(Long taskId) {
        return taskRepo.findById(taskId).get();
    }
    public Task addTask(Task t) {
        return taskRepo.save(t);
    }
    public void removeTask(Long taskId) {
        taskRepo.deleteById(taskId);
    }
    public Task modifyTask(Task task) {
        return taskRepo.save(task);
    }

}
