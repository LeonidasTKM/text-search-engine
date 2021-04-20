package org.example.process;

import org.example.factory.MapFactory;
import org.example.service.FileService;
import org.example.factory.WordFactory;
import org.example.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.example.utils.Constants.filesStore;

public class FileProcess {

    private final FileService fileService = new FileService();

    /**
     * Search words in files
     *
     * @param args
     * @throws IOException
     */
    public void search(String[] args) throws IOException {
        validateArguments(args);
        //Store files content inside a HashMap
        final File indexableDirectory = new File(args[0]);
        fileService.storeFilesContent(indexableDirectory, filesStore);

        try (Scanner keyboard = new Scanner(System.in)) {
            while (true) {
                System.out.print(Constants.SEARCH);
                final String line = keyboard.nextLine();
                if (Constants.EXIT.contains(line)) {
                    break;
                }
                // Find words inside a file contain (value of the map) and store the percent inside a hashmap
                List<String> wordsList = Arrays.asList(line.trim().split(Constants.WHITE_SPACE));
                final Map<String, Float> wordsPercentInFile = new LinkedHashMap<>();
                filesStore.forEach((k, v) -> wordsPercentInFile.put(k, WordFactory.calculatePercentOfWordsFoundInText(v.toLowerCase(), wordsList)));

                // Remove all files that have a percentage of 0
                Map<String, Float> filteredWordPercentInFile = MapFactory.removeZeroValues(wordsPercentInFile);
                if (filteredWordPercentInFile.isEmpty()) {
                    System.out.println("No Match found");
                    continue;
                }
                //Print the final result
                int i = 0;
                List<Map.Entry<String, Float>> sortedFilteredWordPercentInFile = MapFactory.sortByDescendingOrder(filteredWordPercentInFile);
                for (Map.Entry<String, Float> entry : sortedFilteredWordPercentInFile) {
                    System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
                    i++;
                    if (i > 9)
                        break;
                }

            }
        }
    }

    /**
     * Check if arguments are valid
     *
     * @param args
     */
    void validateArguments(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No directory given to index.");
        }
        if (args[0] == null || args[0].trim().split("\\s").length == 0) {
            throw new IllegalArgumentException("No directory given to index.");
        }
    }

}

