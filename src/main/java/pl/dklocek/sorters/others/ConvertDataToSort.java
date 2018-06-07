package pl.dklocek.sorters.others;


public class ConvertDataToSort {
  public static int[] convertToInt(String numbersInString){

      if(numbersInString.length()==1){
          int[] number = new int[1];
          number[0] = Integer.parseInt(numbersInString);
          return number;
      }

      String[] numbersInStringArray = numbersInString.split(",");
      int[] numbers = new int[numbersInStringArray.length];
      for (int i = 0; i < numbersInStringArray.length; i++) {

          numbers[i] = Integer.parseInt(numbersInStringArray[i]);
      }
      return numbers;
  }

  public static String[] convertToString(String dataToSort){

      dataToSort.trim();

      return dataToSort.split(",");
  }

}
