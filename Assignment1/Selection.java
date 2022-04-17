import java.util.Random;

public class Selection {

    private int[] emptyArray;

    private long timeElasped = 0;

    public long getTimeElasped(){
        return this.timeElasped;
    }

    public int[] get_emptyArray(){
        return this. emptyArray;
    }

    public void setIntArray(int[] array){
        this.emptyArray = array;
    }

    public int[] createArray(int size){
        int[] filledArray = new int[size];
        Random ran = new Random();

        for (int i = 0; i < size; i++){
            filledArray[i] = ran.nextInt();
        }

        return filledArray;
    }

    public int[] reverse(int[] a){ //geeks for geeks
        int n = a.length;
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

        return b;

    
    }
}
