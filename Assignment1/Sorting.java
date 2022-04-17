
public class Sorting{

    public void selectionSort(int[] array){
        
        int temp;                                           //1
        int min;                                            //1
        
        for (int i = 0; i < array.length - 1; i++){        //1 + N + N - 1 = 2N    
            min = i;                                        // N - 1
            for (int j = i + 1; j < array.length; j++){    // (N - 1)+ (x + 1) + x
                if (array[j] < array[min])                  //3x
                    min = j;                                //x
            }
            temp = array[min];                              //2(N - 1)
            array[min] = array[i];                          //2(N - 1)
            array[i] = temp;                                //2(N - 1)
        }
        //1 + 1 + 2N + N-1 + N-1 + x+1 + x + 3x + x + 2(N-1) + 2(N-1) + 2(N-1) = 6x + 10N - 5
        // x = 1 + 2 + 3 + ... + (N - 1)
        // x = (N - 1)(N - 1 + 1)/2 = N(N-1)/2
        // T(N) = 6(N(N-1)/2) + 10N - 5
        // T(N) = 3N^2 - 3N + 10N - 5 = 3N^2 + 7N - 5
        // T(N) = O(N^2)     therefore selectionSort has a complexity  of O(N^2)
    }

    public void insertionSort(int[] array){

        for (int i = 1, j; i < array.length; i++){   //1 + N + N - 1 = 2N
            int temp = array[i];                     //1 + 2(N - 1)
            for (j = i; j > 0 && temp < array[j - 1]; j--){ //(N - 1) + x + ( x + 1) + x
                array[j] = array[j - 1];             //3x
            }
            array[j] = temp;                //2(N-1)
        }
        /* T(N) = 2N + 1 + 2(N - 1) + N - 1 + x + (x + 1) + x + 3x + 2(N-1)
        = 6x + 7N - 2
        = 6(N(N-1)/2) + 7N - 2
        = 3N^2 + 4N - 2
        THEREFORE   T(N) = O(N^2)  */
    }
    static void merge(int a[], int beg, int mid, int end)    //javatpoint.com/merge-sort
    {    
        int i, j, k;  
        int n1 = mid - beg + 1;    
        int n2 = end - mid;    
        
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2]; //temporary arrays  
        
        /* copy data to temp arrays */  
        for (int x = 0; x < n1; x++) {
            LeftArray[x] = a[beg + x];  
        }  
        for (int y = 0; y < n2; y++)    
            RightArray[y] = a[mid + 1 + y];    
        
        i = 0; /* initial index of first sub-array */  
        j = 0; /* initial index of second sub-array */   
        k = beg;  /* initial index of merged sub-array */  
        
        while (i < n1 && j < n2)    
        {    
            if(LeftArray[i] <= RightArray[j])    
            {    
                a[k] = LeftArray[i];    
                i++;    
            }    
            else    
            {    
                a[k] = RightArray[j];    
                j++;    
            }    
            k++;    
        }    
        while (i<n1)    
        {    
            a[k] = LeftArray[i];    
            i++;    
            k++;    
        }    
        
        while (j<n2)    
        {    
            a[k] = RightArray[j];    
            j++;    
            k++;    
        }    
    }    

    public void mergeSort(int a[], int beg, int end)  //javatpoint.com/merge-sort
    {  
        if (beg < end)           //N
        {  
            int mid = (beg + end) / 2;    
            mergeSort(a, beg, mid);  
            mergeSort(a, mid + 1, end);  
            merge(a, beg, mid, end);  
        }  
    }

    static void swap(int[] arr, int i, int j) //geeks for geeks
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) //geeks for geeks
    {
        int pivot = arr[high];
        
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    public void quickSort(int[] arr, int low, int high) //geeks for geeks
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    


}
