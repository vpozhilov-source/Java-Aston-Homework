public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
            {"1", "2", "3", "4"},     
            {"5", "6", "7", "8"},     
            {"9", "10", "11", "12"},  
            {"13", "14", "15", "16"}
        };
        
        String[][] wrongDataArray = {
            {"1", "2", "3", "4"},     
            {"5", "6", "seven", "8"},
            {"9", "10", "11", "12"},  
            {"13", "14", "15", "16"}
        };
        
        String[][] wrongSizeArray = {
            {"1", "2", "3"},     
            {"5", "6", "7"}
        };
        
        try {
            int result = ArrayProcessor.processArray(correctArray);
            System.out.println("Sum: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            int result = ArrayProcessor.processArray(wrongDataArray);
            System.out.println("Sum: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            int result = ArrayProcessor.processArray(wrongSizeArray);
            System.out.println("Sum: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
     
