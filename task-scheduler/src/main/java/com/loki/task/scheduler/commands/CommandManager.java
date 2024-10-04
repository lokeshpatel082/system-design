package com.loki.task.scheduler.commands;

import com.loki.task.scheduler.CommandType;
import com.loki.task.scheduler.controller.TaskScheduleController;
import com.loki.task.scheduler.io.TaskSchedulerIO;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private Map<CommandType, Command> commands;
    private final TaskScheduleController taskScheduleController;
    private final TaskSchedulerIO taskSchedulerIO;

    public void executeCommand(CommandType command){
        commands.get(command).execute();
    }

    public Map<CommandType, Command> getCommands() {
        return commands;
    }

    public CommandManager(TaskSchedulerIO taskSchedulerIO, TaskScheduleController taskScheduleController){
        this.taskSchedulerIO = taskSchedulerIO;
        this.taskScheduleController = taskScheduleController;
        this.commands = new HashMap<>();
        initializeCommands();

    }
    public void initializeCommands(){
        commands.put(CommandType.CREATE, new CreateCommand(taskSchedulerIO, taskScheduleController));
        commands.put(CommandType.UPDATE, new UpdateCommand(taskSchedulerIO, taskScheduleController));
        commands.put(CommandType.DELETE, new DeleteCommand(taskSchedulerIO, taskScheduleController));
        commands.put(CommandType.EXIT, new ExitCommand());
    }
    public void run(){

        while(true){
            taskSchedulerIO.displayMenu();
            int choice = taskSchedulerIO.getUserChoice();
            CommandType command = CommandType.fromValue(choice);

            if(commands.containsKey(command)){
                commands.get(command).execute();
            }
            else{
                taskSchedulerIO.displayMessage("Invalid option. Please try again.");
            }
        }
    }


}
