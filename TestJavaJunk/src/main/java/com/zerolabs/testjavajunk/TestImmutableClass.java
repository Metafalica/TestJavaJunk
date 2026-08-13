/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zerolabs.testjavajunk;

/**
 *
 * @author Infel Phira
 */
public final class TestImmutableClass
{
    private final GeneralClass generalClassInstance;
    
    public GeneralClass getGeneralClassInstance()
    {
        return this.generalClassInstance != null ? this.generalClassInstance.clone() : null;
    }
    
    public TestImmutableClass(GeneralClass gc)
    {
        this.generalClassInstance = gc != null ? gc.clone() : null;
    }
}