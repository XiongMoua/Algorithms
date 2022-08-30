package Algorithms;
import java.util.*;

public class Merge_Sort{

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter in the size of randonmized data for the first array: ");
        int dataSize = kb.nextInt();

        System.out.println("Enter in the size of randomized data for the second array: ");
        kb.nextLine();
        int dataSize2 = kb.nextInt();


        Random rand = new Random();
        int[] arr1 = new int[dataSize];
        int[] arr2 = new int[dataSize2];

        //populate the arrays with random data
        for(int i = 0; i <= arr1.length-1; i++){
            arr1[i] = rand.nextInt(999);
            
        }

        for(int i = 0; i<=arr2.length-1;i++){
            arr2[i] = rand.nextInt(999);
        }

        System.out.println("Before Merge Sort");
        ArrayToString(arr1);
        ArrayToString(arr2);

        System.out.println();
        MergeSort(arr1, 0, arr1.length-1);
        System.out.println("After Merge Sort Array 1:");
        System.out.println();
        System.out.println(Arrays.toString(arr1));

        MergeSort(arr2, 0, arr2.length-1);
        System.out.println("After Merge Sort Array 2:");
        System.out.println(Arrays.toString(arr2));
        System.out.println();
        

        System.out.println("Merging the two arrays");
        int[] answer = mergeTwoArrayws(arr1, arr2);
        ArrayToString(answer);

    }

    public static void ArrayToString(int[] arr){
        System.out.print("Array: [");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print( "]");
    }

    public static int[] mergeTwoArrayws(int[] arr1,  int[] arr2){

        int[] newArray = new int[arr1.length + arr2.length];
        // int LARGE = Math.max(L1[n1-1], R1[n2-1]) + 1;
        // // System.out.println("Largest Number: " + LARGE);

        // L1[n1] = LARGE;
        // R1[n2] = LARGE;

        

        int length = Math.max(arr1.length, arr2.length);
        System.out.println();
        System.out.println("Length for the array merge: " + length);

        // 3 counters
        int i = 0, j = 0;
        for(int t = 0; t < newArray.length; t++ ){
            if( i == arr1.length){
                newArray[t] = arr2[j];
                j++;
            }
            else if( j == arr2.length){
                newArray[t] = arr1[i];
                i++;
            }
            else{
                if(arr1[i] < arr2[j]){
                    // System.out.println("The left is being added ");
                    newArray[t] = arr1[i];
                    i++;
                }else{
                    // System.out.println("The right is being added ");
                    newArray[t] = arr2[j];
                    j++;
                }
            }
        }

        return newArray;
    }

    public static void MergeSort(int[] Arr, int p, int r){

        if( p == r ){
            return;
        }

        int q = (p+r)/ 2;

        MergeSort(Arr, p, q); //sorts through the left array
        MergeSort(Arr, q+1, r); //sort through the right array
        Merge(Arr, p, q, r); 



    }

    public static void Merge(int[] Arr, int p, int q, int r){

        // array sizes
        int n1 = q-p+1;
        int n2 = r - q;

        // create two temp arrays
        int[] L1 = new int[n1+1];
        int[] R1 = new int[n2+1];

        // System.out.println("Created new arrays");

        
        //fill in the temp arrays: p to q
        for(int i = 0; i< n1; i++){
            L1[i] = Arr[p+i];
        }

        //fill in the temp array: q+1 to r
        for(int j = 0; j < n2; j++){
            R1[j] = Arr[q + j + 1];
        }

        // ArrayToString(L1);

        // ArrayToString(R1);
        //create the max 
        int LARGE = Math.max(L1[n1-1], R1[n2-1]) + 1;
        // System.out.println("Largest Number: " + LARGE);

        L1[n1] = LARGE;
        R1[n2] = LARGE;

        int i = 0, j = 0;

        for(int k = p; k < r+1; k++){

            if( L1[i] < R1[j]){
                Arr[k] = L1[i];
                i++;
            }
            else{
                Arr[k] = R1[j];
                j++;
            }
            
        }


    }

}