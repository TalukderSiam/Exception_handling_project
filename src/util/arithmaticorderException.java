/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author siamt
 */
public class arithmaticorderException  extends Exception{
     private String singletonString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
	return singletonString + " is a Arithmatic string of oreder two that is found at index " + occurrenceIndex + "!";
    }
    public arithmaticorderException(String singletonString, int index) {
	this.singletonString = singletonString; 
	occurrenceIndex = index;
    }
}
