package Decorator;

import java.util.List;
import java.util.stream.Collectors;

public class OrderedCollectionWriter extends BaseDecorator {    
    public OrderedCollectionWriter(ICollectionWriter collWriter) {
        super(collWriter);
    }

    @Override
    public void write(List<Integer> data, String path) {
        List<Integer> orderedData = data.stream()
                .sorted()
                .collect(Collectors.toList());
        
        super.write(orderedData, path);
    }
}