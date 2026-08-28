package Decorator;

import java.util.List;

public class BaseDecorator implements ICollectionWriter {
    private ICollectionWriter collWriter;
    
    public BaseDecorator(ICollectionWriter collWriter) {
        this.collWriter = collWriter;
    }
    
    @Override
    public void write(List<Integer> data, String path) {
        if (this.collWriter != null) {
            this.collWriter.write(data, path);
        }
        else {
            System.out.println("Broken decorator (coolWriter is NULL).");
        }
    }    
}