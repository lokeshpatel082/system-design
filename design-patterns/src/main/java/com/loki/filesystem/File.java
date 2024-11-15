package com.loki.filesystem;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


class File {
    boolean isDir;
    String name;
    String content;
    Map<String, File> files;

    public File(String name, boolean isDir) {
        this.name = name;
        this.isDir = isDir;
        this.files = new HashMap<>();
        this.content = "";
    }

    public void add(String name, boolean isDir){
        this.files.put(name, new File(name, isDir));
    }

    public void add(File file){
        this.files.put(file.name, file);
    }

    public List<String> getFileNames(){
        List<String> directoryList = new ArrayList<>();
        this.files.forEach((fileName, f) -> directoryList.add(fileName));
        Collections.sort(directoryList);
        return directoryList;
    }

}
