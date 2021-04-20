package org.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileService {

    public void storeFilesContent(File folder, Map<String, String> filesStore) throws IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                System.out.println("Is directory : " + fileEntry.getName());
                storeFilesContent(fileEntry, filesStore);
            } else {
                Path filePath = Path.of(fileEntry.getPath());
                String content = Files.readString(filePath, StandardCharsets.US_ASCII);
                System.out.println(fileEntry.getName() + " : " + content);
                filesStore.put(fileEntry.getName(), content);
            }
        }
    }

}
