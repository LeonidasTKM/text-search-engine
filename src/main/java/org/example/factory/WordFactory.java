package org.example.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordFactory {

    /**
     * Find words in content
     *
     * @param text
     * @param words
     * @return
     */
    public static float calculatePercentOfWordsFoundInText(String text, List<String> words) {
        int totalWords = words.size();
        List<String> wordsFound = new ArrayList<>();
        for (String w : words) {
            Pattern searchPattern = Pattern.compile(".*\\b" + w.toLowerCase() + "\\b.*");
            if (searchPattern.matcher(text).matches()) {
                wordsFound.add(w);
            }
        }
        return (float) (wordsFound.size() * 100 / totalWords);
    }
}
