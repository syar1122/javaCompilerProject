/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author ZETTA
 */
//Implementing Lexical Analyzer
public class Lexical extends Token_table{
    static BufferedReader bReader;
    static FileReader reader;
    static Hashtable<Integer,String[]> hash = new Hashtable();
    
    public Lexical(String fileName) throws FileNotFoundException{
        reader = new FileReader(fileName);
        bReader = new BufferedReader(reader);
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Lexical l=new Lexical("lexical_implement.txt");
       
        String line = "";
        
        int counter = 0;
        while((line = bReader.readLine()) !=null && !(line.matches("//.*"))){
            hash.put(counter, line.split(" "));
            counter++;
        }
        bReader.close();
        
        for (int i = 0; i < counter; i++) {
     
           String [] info = hash.get(i);
      
            for (int j = 0; j < info.length; j++) {
                            
                if(operators(info[j])){
                    System.out.println(info[j] +" is Operator in line "+ i);
                  } else if(keywords(info[j])){
                        System.out.println(info[j]+" is Keyword in line " + (i+1));
                  }else if(dataType(info[j])){
                        System.out.println(info[j]+" is Data Type in line " + (i+1));
                  } else if(bracket(info[j])){
                        System.out.println(info[j]+" is bracket in line " + (i+1));                                         
                  }else {
                        System.out.println(info[j]+" is Identifier in line " + (i +1));
                        break;
                  }
            }
            
        }

}
}
