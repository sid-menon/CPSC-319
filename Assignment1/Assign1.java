import java.io.IOException;
import java.io.PrintWriter;


public class Assign1 {

    public static void main(String[] args) throws IOException{
        Selection select = new Selection();
        Sorting sort = new Sorting();

        int size = Integer.parseInt(args[1]);

        String filename = args[3];

        int[] array = new int[size];
        int[] reverse = new int[size];

        array = select.createArray(size);

        long startTime = System.nanoTime();

        if (args[2].equals("selection")){

            if(args[0].equals("random"))
                array = array;
            
            if(args[0].equals("increasing")){
                sort.selectionSort(array);
            }

            if(args[0].equals("decreasing")){
                sort.selectionSort(array);
                reverse = select.reverse(array);
            }
        
        }

        if (args[2].equals("quick")){

            if(args[0].equals("random"))
                array = array;

            if(args[0].equals("increasing")){
                sort.quickSort(array, 0, array.length - 1);
            }

            if(args[0].equals("decreasing")){
                
                sort.quickSort(array, 0, array.length - 1);
                reverse = select.reverse(array);
            }
        }

        if (args[2].equals("insertion")){

            if(args[0].equals("random"))
                array = array;

            if(args[0].equals("increasing")){
                sort.insertionSort(array);
            }

            if(args[0].equals("decreasing")){
                sort.insertionSort(array);
                reverse = select.reverse(array);
            }
        }

        if (args[2].equals("merge")){

            if(args[0].equals("random"))
                array = array;

            if(args[0].equals("increasing")){
                sort.mergeSort(array, 0, array.length - 1);
            }

            if(args[0].equals("decreasing")){
                
                sort.mergeSort(array, 0, array.length - 1);
                reverse = select.reverse(array);
            }
        }

        long elapsedTime = System.nanoTime() - startTime;
        PrintWriter out = new PrintWriter(filename);
               
        out.println("Elapsed Time in nanoseconds is: " + elapsedTime);
                
        out.close();

        
    }
}
