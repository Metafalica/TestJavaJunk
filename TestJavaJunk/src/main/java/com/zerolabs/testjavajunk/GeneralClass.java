/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zerolabs.testjavajunk;

/**
 *
 * @author Infel Phira
 */
public final class GeneralClass implements Cloneable
{
    private int generalIntegerValue;
    
    public int getGeneralIntegerValue() { return this.generalIntegerValue; }
    public void setGeneralIntegerValue(int value) { this.generalIntegerValue = value; }
    
    public GeneralClass(int generalIntegerValue)
    {
        setGeneralIntegerValue(generalIntegerValue);
    }
    
    @Override
    public GeneralClass clone()
    {
        GeneralClass newGC = null;
        
        try
        {
            newGC = (GeneralClass)super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            int currGenIntVal = getGeneralIntegerValue();
            newGC = new GeneralClass(currGenIntVal);            
        }

        return newGC;   
    }
}