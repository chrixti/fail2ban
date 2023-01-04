/*Christine Lam
cl3903
Fail2Ban.java
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Fail2Ban{
    public static void main(String[] args) throws FileNotFoundException{
    
        File inputFile = new File(args[0]);
        Scanner s = new Scanner(inputFile);
        PrintWriter output = new PrintWriter(args[1]);
        int frequency = 0; //frequency of invalid logins (# of invalid logins)
        
        //list of invalid IP addresses
        ArrayList<String> invalidIP = new ArrayList<String>(); 



        //list of IP addresses that fail 3 or more times
        ArrayList<String> invalidIPMoreThanThree = new ArrayList<String>();
        
         while(s.hasNextLine()){
            String line = s.nextLine();
            String[] input = line.split(" ");

            if (input[5].equals("Invalid")){
                    invalidIP.add(input[9]);
            }
         }
         Collections.sort(invalidIP);
         frequency = 1;
         
         for (int i = 1; i < invalidIP.size(); i++){
        
            /*if IP matches the one before then add 1 to frequency
            * edge case for end of list
            */
            if (invalidIP.get(i).equals(invalidIP.get(i-1)) && i != invalidIP.size()-1){
                 frequency++;
            } else {
                //edge case at end of list checking
                 if(invalidIP.get(i).equals(invalidIP.get(i-1))){
                     frequency++;
                }

                //add IP to the invalidIPMoreThanThree list if it's more than 3
                if (frequency >= 3){
                 System.out.println(frequency);
                 invalidIPMoreThanThree.add(invalidIP.get(i-1));
                }
    
             frequency = 1;
            }
         }
         for (int i = 0; i < invalidIPMoreThanThree.size(); i++){

         output.println("Total IP addresses that fail more than 3 times: " + 
                        invalidIPMoreThanThree.size());
         output.println(invalidIPMoreThanThree.get(i));
       
        }

        s.close();
        output.close();
    }
}