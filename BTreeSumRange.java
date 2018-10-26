import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.*;
import java.util.Scanner;

public class BTreeSumRange {
    public static void main(String[]args) throws IOException {
        String dataFile = "C:\\Users\\simon\\IdeaProjects\\BinaryTreeProgrammingAssignment\\isEvenData\\dataI";
        String rangeFile = "C:\\Users\\simon\\IdeaProjects\\BinaryTreeProgrammingAssignment\\isEvenData\\rangeI";
        Tree tree = new Tree();


        try {
            BufferedReader data = new BufferedReader((new FileReader(dataFile)));
            String value = data.readLine();
            BufferedReader range = new BufferedReader((new FileReader(rangeFile)));
            String rangeString = range.readLine();
            while (value != null) {
                tree.insert(Integer.valueOf(value));
                value = data.readLine();
            }

            while(rangeString != null) {
                String result = "Odd sum";
                Scanner feeder = new Scanner(rangeString);
                while(feeder.hasNextInt()) {
                    int operanda = feeder.nextInt();
                    int operandb = feeder.nextInt();
                    boolean booler  = tree.isEvenSum(operanda, operandb);
                    if (booler == true) {
                        result = "Even sum";
                    }
                    System.out.println("Range{ " + operanda + ", " + operandb + " } : " + result );
                }
                rangeString = range.readLine();
            }
            return;
        } catch(FileNotFoundException filenotfoundexception)
        {
            System.out.println("File unavailable");
        }
	        catch(IOException ioexception)
        {
            System.out.println("Something is wrong witht he file input");
        }

    }
}
