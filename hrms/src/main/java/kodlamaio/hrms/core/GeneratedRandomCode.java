package kodlamaio.hrms.core;

import java.util.Random;

public class GeneratedRandomCode {

    int length = 10;
 
    StringBuilder sb = new StringBuilder();

    Random random = new Random();
    
	String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";

    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;


    for(int i = 0; i < length; i++) {

      int index = random.nextInt(alphaNumeric.length());

      char randomChar = alphaNumeric.charAt(index);

      sb.append(randomChar);
      
      String randomString = sb.toString();
      
      return randomString;
    }
}
