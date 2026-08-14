package com.zerolabs.testjavajunk;

public final class TestImmutableClass {
    private final GeneralClass generalClassInstance;
    
    public GeneralClass getGeneralClassInstance() {
        return this.generalClassInstance != null ? this.generalClassInstance.clone() : null;
    }
    
    public TestImmutableClass(GeneralClass gc) {
        this.generalClassInstance = gc != null ? gc.clone() : null;
    }
}