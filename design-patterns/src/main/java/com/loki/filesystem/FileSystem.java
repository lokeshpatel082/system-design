package com.loki.filesystem;

import com.loki.filesystem.exceptions.DirectoryNotFound;
import com.loki.filesystem.exceptions.InvalidPath;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private final File root;
    private String currentFile;

    public FileSystem() {
        this.root = new File("/", true);
        this.currentFile = "/";
    }

    public List<String> ls() {
        return this.ls(currentFile);
    }

    public List<String> ls(String path) throws DirectoryNotFound {
        String newPath = (path.charAt(0) == '/') ? path : currentFile + "/" + path;
        File startFile = this.root;
        String[] pathList = newPath.split("/");

        for (int i = 1; i < pathList.length; i++) {
            String dir = pathList[i];
            if (!startFile.files.containsKey(dir)) {
                throw new DirectoryNotFound("Can not found directory \"" + newPath);
            }
            startFile = startFile.files.get(dir);
        }
        if (!startFile.isDir) {
            throw new DirectoryNotFound("given path" + newPath + " is not a directory");
        }
        return startFile.getFileNames();
    }

    public void mkdir(String path) {
        String newPath = (path.charAt(0) == '/') ? path : currentFile + "/" + path;
        File startFile = this.root;
        String[] pathList = newPath.split("/");

        for (int i = 1; i < pathList.length; i++) {
            String dir = pathList[i];
            if (!startFile.files.containsKey(dir)) {
                startFile.add(dir, true);
            }
            startFile = startFile.files.get(dir);
        }

    }

    public void touch(String path) {
        String newPath = (path.charAt(0) == '/') ? path : currentFile + "/" + path;
        File startFile = this.root;
        String[] pathList = newPath.split("/");

        for (int i = 1; i < pathList.length; i++) {
            String dir = pathList[i];
            if (!startFile.files.containsKey(dir)) {
                startFile.add(dir, true);
            }
            startFile = startFile.files.get(dir);
        }
        startFile.isDir = false;
    }

    public void rm(String path) {
        String newPath = (path.charAt(0) == '/') ? path : currentFile + "/" + path;
        File startFile = this.root;
        File parentFile = null;
        String[] pathList = newPath.split("/");

        for (int i = 1; i < pathList.length; i++) {
            String dir = pathList[i];
            if (!startFile.files.containsKey(dir)) {
                throw new InvalidPath("Invalid Path: " + newPath);
            }
            parentFile = startFile;
            startFile = startFile.files.get(dir);
        }
        if (parentFile == null) {
            throw new InvalidPath("can not remove directory" + newPath);
        }
        parentFile.files.remove(startFile.name);

        System.out.println("Directory removed successFully");

    }

    public void cd(String path) {
        String newPath = (path.charAt(0) == '/') ? path : currentFile + "/" + path;
        if (!isValidPath(newPath)) {
            throw new InvalidPath("Not a valid directory path");
        }
        this.currentFile = newPath;
    }

    private boolean isValidPath(String path) {
        File startFile = this.root;
        String[] pathList = path.split("/");

        for (int i = 1; i < pathList.length; i++) {
            String dir = pathList[i];
            if (!startFile.files.containsKey(dir)) {
                return false;
            }
            startFile = startFile.files.get(dir);
        }
        if (!startFile.isDir) return false;
        return true;
    }
    private String getAbsolutePath(String path){
       return  (path.charAt(0) == '/') ? path : currentFile + "/" + path;
    }
    public void mv(String sourcePath, String destinationPath){
        String absoluteSourcePath = getAbsolutePath(sourcePath);
        String absoluteDestinationPath = getAbsolutePath(destinationPath);

        List<File> sourceFileList = getLastFiles(absoluteSourcePath);
        List<File> destinationFileList = getLastFiles(absoluteDestinationPath);

        File sourceLastFile = sourceFileList.get(0);
        File parentFile = sourceFileList.get(1);
        File destinationLastFile = destinationFileList.get(0);
        if (parentFile == null) {
            throw new InvalidPath("can not move directory" + absoluteSourcePath);
        }

        if(destinationLastFile.isDir){
            parentFile.files.remove(sourceLastFile.name);
            destinationLastFile.add(sourceLastFile);
        }
        else{
            if(sourceLastFile.isDir){
                throw  new InvalidPath("can not move directory to " + destinationPath);
            }
            // TODO: delete sourceLastFile from parentFile
            // TODO: copy content from sourceLastFile to destinationLastFile
        }
        System.out.println("Directory/file moved successFully");
    }

    private List<File> getLastFiles(String path){
        File startFile = this.root;
        File parentFile = null;
        String[] pathList = path.split("/");

        for (int i = 1; i < pathList.length; i++) {
            String dir = pathList[i];
            if (!startFile.files.containsKey(dir)) {
                throw new InvalidPath("Invalid Path: " + path);
            }
            parentFile = startFile;
            startFile = startFile.files.get(dir);
        }
        return List.of(startFile, parentFile);
    }
}

