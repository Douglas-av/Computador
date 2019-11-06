
public class metodosOrdenacao {
	public static int[] ordenacaoInsercao(int arr[])  
	{  
	    int i, key, j;  
	    for (i = 1; i < arr.length; i++) 
	    {  
	        key = arr[i];  
	        j = i - 1;  
	  
	        /* Move elements of arr[0..i-1], that are  
	        greater than key, to one position ahead  
	        of their current position */
	        while (j >= 0 && arr[j] > key) 
	        {  
	            arr[j + 1] = arr[j];  
	            j = j - 1;  
	        }  
	        arr[j + 1] = key;  
	    }  
	    return arr;
	}  
	
   public static int[] ordenacaoSelecao(int[] input) {

        for (int i = 0; i < input.length - 1; i++) {

            int min = i;

            // find the first, second, third, fourth... smallest value
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }

            // swaps the smallest value with the position 'i'
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;

            //next pls
        }
        return input;

    }
   
  public static void ordenacaoSelecaoString( String[] array )
  {
    for ( int j=0; j < array.length-1; j++ )
    {
      int min = j;
      for ( int k=j+1; k < array.length; k++ )
        if ( array[k].compareTo( array[min] ) < 0 ) min = k;  

      String temp = array[j];
      array[j] = array[min];
      array[min] = temp;
    }
  
  }
  
  public String[] ordenacaoInsercaoString(String[] array){
	    int length = array.length;
	    String value;
	    int index;

	    for(int a = 1; a < length; a++){
	        value = array[a];
	        index = a;
	        while(index > 0 && array[index-1].compareToIgnoreCase(value) > 0) {
	            array[index] = array[index - 1];
	            --index;
	        }
	        array[index] = value;
	    }
	    return array;
	}

}
