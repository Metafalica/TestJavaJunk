package Decorator;

import java.util.List;
import java.util.stream.Collectors;

public class ZeroFreeCollectionWriter extends BaseDecorator {    
    public ZeroFreeCollectionWriter(ICollectionWriter collWriter) {
        super(collWriter);
    }
    
    @Override
    public void write(List<Integer> data, String path) {
        List<Integer> zeroFreeData = data.stream()
                .filter(n -> n != 0)
                .collect(Collectors.toList());
        
        super.write(zeroFreeData, path);
    }
}