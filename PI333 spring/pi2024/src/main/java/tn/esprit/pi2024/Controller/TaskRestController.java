package tn.esprit.pi2024.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import tn.esprit.pi2024.Entity.Task;
import tn.esprit.pi2024.Service.ITaskService;

import java.util.List;

@Tag(name = "Gestion Task")
@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskRestController {
    ITaskService taskService;
    // http://localhost:8089/tpfoyer/task/retrieve-all-tasks
    @Operation(description = "Récupérer tous les tasks de la base de données!")
    @GetMapping("/retrieve-all-tasks")
    public List<Task> getTasks() {
        return taskService.retrieveAllTasks();
    }

    // http://localhost:8089/tpfoyer/task/retrieve-task/8
    @Operation(description = "Récupérer le task avec l'ID correspondante de la base de données!")
    @GetMapping("/retrieve-task/{task-id}")
    public Task retrieveTask(@PathVariable("task-id") Long taskId) {
        return taskService.retrieveTask(taskId);
    }

    // http://localhost:8089/tpfoyer/task/add-task
    @Operation(description = "Ajouter task à la base de données!")
    @PostMapping("/add-task")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    // http://localhost:8089/tpfoyer/task/remove-task/{task-id}
    @Operation(description = "Enlever le task avec l'ID correspondante de la base de données!")
    @DeleteMapping("/remove-task/{task-id}")
    public void removeTask(@PathVariable("task-id") Long taskId) {
        taskService.removeTask(taskId);
    }

    // http://localhost:8089/tpfoyer/task/modify-task
    @Operation(description = "Modifier le task!")
    @PutMapping("/modify-task")
    public Task modifyTask(@RequestBody Task task) {
        return taskService.modifyTask(task);
    }

}
