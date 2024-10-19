package com.loki.splitwise;

import com.loki.splitwise.model.Group;

import java.util.HashMap;
import java.util.Map;

public class GroupController {
    private Map<String, Group> groupList;
    private ExpenseService expenseService;

    public GroupController(ExpenseService expenseService){
        this.groupList = new HashMap<>();
        this.expenseService = expenseService;
    }
    public void addGroup(Group group){
        groupList.put(group.getGroupId(), group);
    }

    public Group getGroup(String id){
        return groupList.get(id);
    }


    public String createGroup(String id, String name){
        Group newGroup = new Group(id, name, expenseService);
        groupList.put(newGroup.getGroupId(), newGroup);
        return newGroup.toString();
    }




}
