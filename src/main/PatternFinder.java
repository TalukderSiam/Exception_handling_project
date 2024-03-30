package main;

import util.*;
import java.util.*;

public class PatternFinder {
    private static String randomStringGenerator(int length) {// generates a string made of randomly generated lowercase
							     // letters.
	Random random = new Random(System.nanoTime());
	char[] array = new char[length];
	for (int i = 0; i < length; i++)
	    array[i] = (char) ('a' + random.nextInt(26));
	return new String(array);
    }
    private static void singletonMiner(String mine, int length) throws SingletonException{
        System.out.println("i am from single ton");
	for (int start = 0; start <= mine.length() - length; start++) {
	    int i;
	    for (i = start + 1; i < start + length; i++)
		if (mine.charAt(i) != mine.charAt(i - 1))
		    break;
	    if (i == start + length)
		throw new SingletonException(mine.substring(start, start + length), start);
	}
    }
    
    private static void arithmathmeticOder (String mine ,int length) throws arithmaticorderException{
         System.out.println("i am from arith ton");
        for(int start=0;start<=mine.length()-length ;  start++){
            for(int i=start ; i<start+length ; i++ ){
                if(mine.charAt(i)-mine.charAt(i+1)!=1){
                    break;
                }
                if(i+1==start +length){
                   throw new arithmaticorderException(mine.substring(start, start + length), start); 
                }
            }
        }
    }
    
    private static void arithmathmeticOder1(String mine ,int length) throws arithmaticorderException1{
         System.out.println("i am from arithmatic ton");
        for(int start=0;start<=mine.length()-length ;  start++){
            for(int i=start ; i<start+length ; i++ ){
                if(mine.charAt(i)-mine.charAt(i+1)!=-1){
                    break;
                }
                if(i+1==start +length){
                   throw new arithmaticorderException1(mine.substring(start, start + length), start); 
                }
            }
        }
    }
    
    
    private static void balancetri(String mine ,int length) throws balancetriException{
         System.out.println("i am from balace  ton");
        if(length%3==0){
            int dis=(length)/3;
            int cnt=0;
        for(int start=0; start<=mine.length()-length;  start++){
                  String part1 = mine.substring(start, start+dis);
            String part2 = mine.substring(start+dis,start+2*dis);
            String part3 = mine.substring(start+2*dis,  start +3*dis);

            if (part1.equals(part2) && part2.equals(part3)) {
               throw new balancetriException(mine.substring(start, start + length), start); 
            }    
            }
        }
    }
    
    
     private static void balancedouble(String mine ,int length) throws balancedoubleException{
         System.out.println("i am from balacedd  ton");
        if(length%2==0){
            int dis=(length)/2;
            int cnt=0;
        for(int start=0; start<mine.length()-length;  start++){
                  String part1 = mine.substring(start, start+dis);
                  String part2 = mine.substring(start+dis,start+2*dis);
           

            if (part1.equals(part2)) {
               throw new balancedoubleException(mine.substring(start, start + length), start); 
            }    
            }
        }
    }
     
      private static void palindrom(String mine ,int length) throws palindromException{
       
        for(int start=0; start<=mine.length()-length;  start++){
            
           int left=start;
           int right=start+length-1;
           int cnt=0;
           while(left<right){
               if (mine.charAt(left) != mine.charAt(right)) {
                break;
            }
            left++;
            right--;
            cnt++;
           }
           

            if (cnt==length/2) {
               throw new palindromException(mine.substring(start, start + length), start); 
            }    
            }
        }
    
    
    
    
    
    

    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	//Step 1: handling input...
	System.out.println("Enter the length of random string: ");
	//int patternMaxLength = 10;//you need to update this part so that the value is given by the user via keyboard!
        
	int randomStringLength = keyboard.nextInt();
        
        System.out.println("Enter the length of special pattern;");
        
        int patternMaxLength=keyboard.nextInt();
	while (true) {
	    try {
		if (randomStringLength < 100000 || randomStringLength > 1000000000 || patternMaxLength < 3 || patternMaxLength > 15  )
		    throw new NumberFormatException();
	    } catch (NumberFormatException e) {
		System.out.println("Try again!");
                System.out.println("Enter the length of random string: ");
		randomStringLength = keyboard.nextInt();
                System.out.println("Enter the length of special pattern;");
                patternMaxLength=keyboard.nextInt();
                
		continue;
	    }
	    break;
	}
        
        
	//Step 2: generating random string...
	String randomString = randomStringGenerator(randomStringLength);
        
        System.out.println(randomString);
        
	//Step 3: finding the interesting patterns
    	try {
    	    for (int length = patternMaxLength; length > 0; length--){
                palindrom(randomString ,length);
                balancedouble(randomString ,length);
                balancetri(randomString, length);
                arithmathmeticOder(randomString, length);
                arithmathmeticOder1(randomString, length);
                singletonMiner(randomString, length);
            }  
    	} catch (Exception exp) {
    	    System.out.println(exp.getMessage());
    	}
    }
}
