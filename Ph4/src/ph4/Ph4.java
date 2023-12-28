


package ph4;

import java.util.Scanner;



class CodeGenerator {
    public static String generateSumCode(String className, String methodName, int numOfIteration) {
        StringBuilder code = new StringBuilder();


   code.append("        for (i = 0; i < data.size() - ").append(numOfIteration - 1).append("; i += ").append(numOfIteration).append(") {\n");

  // Unrolled loop body
    // before Code Generation PHase 4

    // handle input
    
  for (int j = 0; j < numOfIteration; ++j) {
       code.append("            result += data.get(i + ").append(j).append(");\n");
        }





        // after  Code Generation PHase 4
        code.append("        }\n\n")
            .append("        // The Number of loop is: ").append(numOfIteration).append("\n")
            .append("        for (; i < data.size(); ++i) {\n")
            .append("            result += data.get(i);\n")
            .append("        }\n\n")
            .append("        return result;\n")
            .append("    }\n")
            .append("}\n");

        return code.toString();
    }
}





public class Ph4 {


    public static void main(String[] args) {

        // Get user input for class name, method name, and loop unrolling factor
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        System.out.print("Enter method name: ");
        String methodName = scanner.nextLine();
        System.out.print("Enter loop num of iterations: ");
        int numOfIteration = scanner.nextInt();
        // Generate code based on user input
        String generatedCode = CodeGenerator.generateSumCode(className, methodName, numOfIteration);
        // Print the generated code
        System.out.println(generatedCode);
        
        
    }
}


// MySumCalculator
// calculateSum   
// 5 
