package pl.dklocek.sorters.backend;


public class StringToIntArray {
  public static int[] StringToIntArray(String numbersInString){

      String[] numbersInStringArray = numbersInString.split(",");
      int[] numbers = new int[numbersInStringArray.length];
      for (int i = 0; i < numbersInStringArray.length; i++) {

          numbers[i] = Integer.parseInt(numbersInStringArray[i]);
      }
      return numbers;
  }

}
