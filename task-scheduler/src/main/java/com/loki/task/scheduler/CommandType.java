package com.loki.task.scheduler;

public enum CommandType {
    CREATE(1),
    UPDATE(2),
    DELETE(3),
    EXIT(4);

    private int value;

    private CommandType(int value) {
        this.value = value;
    }
    public int value(){
        return this.value;
    }
    public static CommandType fromValue(int value){
        for(CommandType command: CommandType.values()){
            if(command.value() == value){
                return command;
            }
        }
        throw new IllegalArgumentException("\"Invalid command value: \" + value");
    }

}
