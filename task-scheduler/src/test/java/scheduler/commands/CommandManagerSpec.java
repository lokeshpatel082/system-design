package scheduler.commands;

import com.loki.task.scheduler.commands.CommandManager;
import com.loki.task.scheduler.controller.TaskScheduleController;
import com.loki.task.scheduler.io.TaskSchedulerIO;
import com.loki.task.scheduler.repository.TaskRepository;
import com.loki.task.scheduler.service.SchedularService;
import com.loki.task.scheduler.service.impl.SchedulerServiceImpl;

import java.util.HashMap;

public class CommandManagerSpec {

    public CommandManager beforeEach() {
        TaskSchedulerIO taskSchedulerIO = new TaskSchedulerIO();
        TaskRepository taskRepository = new TaskRepository(new HashMap<>());
        SchedularService schedularService = new SchedulerServiceImpl(taskRepository);
        TaskScheduleController taskScheduleController = new TaskScheduleController(schedularService);
        return new CommandManager(taskSchedulerIO, taskScheduleController);
    }

    public void intializeCommandTest() {
        CommandManager commandManager = this.beforeEach();
        commandManager.initializeCommands();
        System.out.println(commandManager.getCommands().size() == 4);
    }
}
