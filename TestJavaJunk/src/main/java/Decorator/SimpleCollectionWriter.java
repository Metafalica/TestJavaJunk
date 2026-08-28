package Decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCollectionWriter implements ICollectionWriter {
    @Override
    public void write(List<Integer> data, String path) {
        try {
            List<String> strings = data.stream()
                                          .map(String::valueOf)
                                          .collect(Collectors.toList());
            Files.write(Path.of(path), strings);            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}