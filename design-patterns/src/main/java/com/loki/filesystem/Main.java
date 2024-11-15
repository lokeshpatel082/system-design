package com.loki.filesystem;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/a/b/c");
        fs.touch("/a/b/abc.txt");
        fs.touch("/a/b/c/abc.txt");
        fs.mkdir("/a/b/d");

        System.out.println(fs.ls().toString());
        fs.cd("/a/b");
        System.out.println(fs.ls("/a/b").toString());

    }
}
