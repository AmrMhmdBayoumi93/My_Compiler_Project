
package lexical_pro;


import java.util.regex.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
            // LEXICaL ANALYZER PH 

key words - while, void, if, for, ...

identifiers - declared by the programmer

operators - +, -, *, /, =, ==, ...

numeric constants - numbers such as 124, 12.35, 0.09E-23, etc.

character constants - single characters or strings of characters

special characters - characters used as delimiters such as . ( ) , ; :

comments - ignored by subsequent phases. These must be
identified by the scanner, 


*/
public class Lexical_Pro {

   
    public static void main(String[] args) {
        
     Scanner();
    }
    
    static String identiferRegularExperssion = "[_][0-9][_a-zA-Z]+";  // character 0 or more
    static String digit = "[0-9]+"; // digit 0 or more
    static String comment = "[/][*][_a-zA-Z]+";
    static String Output="\'[a-zA-Z]+\'";
    
    static String token;    // token 
    static Scanner inputCode; // inputcode 
    
    
    
    
    
    static String Filename = "Truecode.txt";  //  this is file name 
    // **** take input from file 
    
    
 // static String Filename = "ErrorTrueCode.txt";  //  this is file name 
 // static String Filename = "Errorcode.txt";  //  this is file name 
    
    
            // end of reg ex 
  
    
  
    static List keywords = new ArrayList();
    static List symbols = new ArrayList();
    static List Operation = new ArrayList();
    static List logialOP = new ArrayList();

    public static void Scanner() {
        
        keywords.add("if");keywords.add("else");keywords.add("elseif");
        keywords.add("for");keywords.add("while");keywords.add("do");
        keywords.add("return");keywords.add("public");keywords.add("privet");
        keywords.add("protect");keywords.add("package");keywords.add("new");
        keywords.add("int");keywords.add("double");keywords.add("float");
        keywords.add("static");keywords.add("const");keywords.add("char");
        keywords.add("goto");keywords.add("boolean");keywords.add("long");
        keywords.add("void");keywords.add("this");keywords.add("try");
        keywords.add("catch");keywords.add("true");keywords.add("print");
        keywords.add("enter");
        
        
        symbols.add("!");symbols.add('&');symbols.add('^');symbols.add('%');
        symbols.add('$');symbols.add('#');symbols.add('@');symbols.add('?');
        symbols.add('~');
        symbols.add("(*"); //begin the condition
        symbols.add("*)"); //end the condition 
        symbols.add("{*"); //begin the loop
        symbols.add("*}"); //end for loop
        symbols.add(";");
        symbols.add("'"); //use to print
       
        Operation.add("+");
        Operation.add("-");     
        Operation.add("*");
        Operation.add("/");             // arithmetic operator 
        Operation.add("=");

        logialOP.add("||");
        logialOP.add("&&");
        logialOP.add("==");
        logialOP.add("<=");    // logical  operator 
        logialOP.add(">=");
        logialOP.add(">");
        logialOP.add("<");

        String tokenCategory;   // result type  -->Classification 
        int line = 1;
        try {
            inputCode = new Scanner(new File(Filename));
            while (inputCode.hasNext()) {
                token = inputCode.next();
                if (keywords.contains(token)) {
                    tokenCategory = "keyword";
                } else if (symbols.contains(token)) {
                    tokenCategory = "Symbol";
                } else if (Operation.contains(token)) {
                    tokenCategory = "operation";
                } else if (logialOP.contains(token)) {
                    tokenCategory = "Logical Operation";
                } else if (Pattern.matches(identiferRegularExperssion, token)) {
                    tokenCategory = "identifire";
                } else if (Pattern.matches(comment, token)) {
                    tokenCategory = "comment";
                } else if (Pattern.matches(digit, token)) {
                    tokenCategory = "digit";
                } else if (Pattern.matches(Output, token)) {
                    tokenCategory = "Output to the user";
                } else {
                    tokenCategory = "there an error in token !!! in line :" + line;
                }
                System.out.println("<" + token + "," + tokenCategory + ">");
                if (token.endsWith(";")) {
                    line++;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File code not found !!");
        }
    }
}
