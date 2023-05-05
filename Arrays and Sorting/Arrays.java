import java.util.*;
public class Arrays{
	public static void main(String[] args){

	}

// ==========================SECOND LARGEST/SMALLEST ELEMENT IN ARRAY ====================================
 
 // 1. Brutforce - > Sort and return arr[n-1] ->doesn't work for same elements

 // 2.Brutforece better ->  Sort and check arr[i] != largest
	 static int print2largest(int[] arr, int n) {
        // code here

        // Arrays.sort(arr);// sort the array
        int second = -1; // in case if all elements are same
        int largest = arr[n-1]; // largest element
        for( int i = n-2 ; i>= 0 ; i--){
            if( arr[i] != largest){
                second = arr[i];
                break;
            }
        }
        return second;
    }

   // 3. Better Approach -> 2 pass solution ( Find largest in first travesal and secondlargest in second)


    // 4. Optimal Approach - > O(n)
    // Logic -> If someone becomes the largest then current largest becomes the second largest

    static int print_Second_largest(int arr[], int n) {
        // code here
        int second = -1; // in case if all elements are same
        int largest = arr[0]; // largest element
        for( int i = 0; i < n ; i++){
            if( arr[i] > largest){
                second = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > second){
                second = arr[i];
            }
        }
        return second;
    }
    

    // codestudio -> second largest and second smallest 

    public static int largest(int n, int[] arr){
        int second = -1; // in case if all elements are same
        int largest = arr[0]; // largest element
        for( int i = 1; i < n ; i++){
            if( arr[i] > largest){
                second = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > second){
                second = arr[i];
            }
        }
        return second;
    }
    public static int secondSmallest(int n, int[] arr){
        int second = -1; // in case if all elements are same
        int smallest = Integer.MAX_VALUE; // smallest element
        for( int i = 0; i < n ; i++){
            if( arr[i] < smallest){
                second = smallest;
                smallest = arr[i];
            }else if(arr[i] > smallest && arr[i] < second){
                second = arr[i];
            }
        }
        return second;
    }




// ===================================== REMOVE DUPLICATES FROM SORTED ARRAY===========================
// 1. Using TreeSet to keep sorted elements and then populating the array
  public int removeDuplicates(int[] arr) {
        SortedSet<Integer> set
            = new TreeSet<Integer>();
        for( int val : arr){
            set.add(val);
        }
        
        int index = 0;
       for(Integer val : set){
           arr[index++] = val;
           
       }
        return index;  
    }

    // 2. Optimal Approach -> Two Pointer ( i = 0 and j = i + 1)

    public int removeDuplicates_Better(int[] arr) {
        if( arr.length == 1) return arr.length;
        int n = arr.length;
        int i = 0, j = i+1;
        while(j < n){
            if( arr[i] != arr[j]){ // unique elements
                arr[++i] = arr[j];
            }
            j++;
        }
      return i+1; // i+1 is the number of unique elements 
    }

// =============================== Majority ele > n/2 ===========================
    static int majorityElement(int arr[], int size)
    {
       int cnt = 0;
        int el = 0;
        for( int i = 0 ; i < arr.length ; i++){
            if( cnt == 0){
                el = arr[i];
                cnt = 1; // set new count for potential majority ele
            }else if( arr[i] == el){
                cnt++; // increment count
            }else{
                cnt--;
            }
        }
      // now el stores potential majority element
       int cnt1 = 0;
       for( int val : arr){
           if( el == val) cnt1++;
       }
       return cnt1 > arr.length/2 ? el : -1;
    }


}