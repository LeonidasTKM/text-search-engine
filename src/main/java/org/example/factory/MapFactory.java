package org.example.factory;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFactory {

    public static List<Map.Entry<String, Float>> sortByDescendingOrder(Map<String, Float> map) {
        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());
    }

    public static Map<String, Float> removeZeroValues(Map<String, Float> map) {
        return map.entrySet().stream()
                .filter(x -> x.getValue() != 0F)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
