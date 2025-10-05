public class ArrayProcessor {
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }
    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
        public static void checkSize(String[][] array) throws MyArraySizeException {
    if (array.length != 4) {
        throw new MyArraySizeException("Array must be 4х4! Received rows: " + array.length);
    }
    for (int i = 0; i < array.length; i++) {
        if (array[i].length != 4) {
            throw new MyArraySizeException("Row " + i + " must have 4 elements! Received: " + array[i].length);
        }
    }
}
public static int sumArrayElements (String [] [] array)throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                        try {
    int number = Integer.parseInt(array[i][j]);
    sum = sum + number;
} catch (NumberFormatException e) {
                                
    throw new MyArrayDataException("Error in the cell [" + i + "][" + j + "]");
}
}
        }
        return sum;
}
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
    checkSize(array);              
    return sumArrayElements(array); 
}
    public static void main(String[] args) {
        String[][] array4x4 = {
            {"1", "2", "3", "4"},     
            {"5", "6", "7", "8"},     
            {"9", "10", "11", "12"},  
            {"13", "14", "15", "16"}
        };
        
        try {
        int result = processArray(array4x4);
        System.out.println("Size M right! Sum: " + result);
    } catch (MyArraySizeException e) {
        System.out.println("Size error: " + e.getMessage());
    } catch (MyArrayDataException e) {
        System.out.println("Data error: " + e.getMessage()); 
    }
}
}
     
