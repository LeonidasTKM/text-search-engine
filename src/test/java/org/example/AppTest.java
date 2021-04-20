package org.example;

import static org.junit.Assert.assertEquals;

import org.example.factory.WordFactory;
import org.example.process.FileProcess;
import org.example.service.FileService;
import org.example.utils.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */

public class AppTest {

    private final FileService fileService = new FileService();

    @Test
    public void shouldFindWordInText() {
        String denisAndMaxime = "denis maxime";
        List<String> words = Arrays.asList("denis", "robert");
        float percent = WordFactory.calculatePercentOfWordsFoundInText(denisAndMaxime, words);
        assertEquals(50.0F, percent, 1);
        words = Arrays.asList("denis", "maxime");
        percent = WordFactory.calculatePercentOfWordsFoundInText(denisAndMaxime, words);
        assertEquals(100.0F, percent, 1);
    }


    @Test
    public void shouldStoreDataInMap() throws URISyntaxException, IOException {
        String denisAndMaxime = "denis maxime";
        URL resource = getClass().getClassLoader().getResource("files");
        File fileFolder = new File(resource.toURI());
        fileService.storeFilesContent(fileFolder, Constants.filesStore);
        String fileContent = Constants.filesStore.get("file1.txt");
        assertEquals(denisAndMaxime, fileContent);
    }
}
