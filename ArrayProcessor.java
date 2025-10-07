public class ArrayProcessor {
    public static void checkSize(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Array must be 4x4! Received rows: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Row " + i + " must have 4 elements! Received: " + array[i].length);
            }
        }
    }
    
    public static int sumArrayElements(String[][] array) throws MyArrayDataException {
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
}
