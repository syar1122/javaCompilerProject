/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ZETTA
 */
public class Token_table{
    
    public static boolean operators(String input){
        
        Pattern p = Pattern.compile("=|\\+|-|\\/|\\*");
        Matcher m = p.matcher(input);
        if(m.find()){           
            return true;
        }else
            return false;
    }
    
    public static boolean keywords(String input){
        String keys = "import|public|private|default|protected|for|while|do|class|extends|implements|static|void|main|super|return|false|true";
        Pattern p = Pattern.compile(keys);
        Matcher m = p.matcher(input);
        if(m.find()){
//            System.out.println("Found "+m.group());
            return true;
        }else
            return false;
        
    }
    
    public static boolean dataType(String input){
        
        Pattern p = Pattern.compile("int|String|boolean|float|double");
        Matcher m = p.matcher(input);
        if(m.find()){
            
            return true;
        }else
            return false;
    }
        
    public static boolean bracket(String input){
        
        Pattern p = Pattern.compile("[({<)}>\\[\\]]");
        Matcher m = p.matcher(input);
        if(m.find()){            
            return true;
        }else
            return false;
    }
    

    
    
}
