package org.example;

import org.example.process.FileProcess;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        FileProcess fileProcess = new FileProcess();
        fileProcess.search(args);
    }
}
