public static void selectionSort(int[] arr){
 	for( int i = 0; i < arr.length ; i++){
 		int min = i;
 		for( int j = i; j < arr.length ; j++){
             if( arr[j] < arr[min]){
             	min = j;
             }
 		}
 		// swaping
 		int temp = arr[i];
 		arr[i] = arr[min];
 		arr[min] = temp;
 	}
 	for( int val : arr){
 		System.out.print(val + " ");
 	}
 }

// ==================================== BUBBLE SORT ===============================

  public static void bubble_Sort(int[] arr, int n){
        //code here
        for( int i = n-1 ; i >= 1 ; i--){
            int didswap = 0;
            for( int j = 0 ; j <= i - 1 ; j++){
                if( arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didswap = 1;
                }
            }
            if(didswap == 0) break;
        }
    }

// ========================================= MERGE SORT ==================================
    class mergeSort
{
     void merge(int[]nums,int low,int mid,int high){
        int left=low,right=mid+1;
        ArrayList<Integer> li = new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                li.add(nums[left++]);
            }
            else{
                li.add(nums[right++]);
            }
        }
        while(left<=mid){
            li.add(nums[left++]);
        }
        while(right<=high){
            li.add(nums[right++]);
        }
        //most important part of algo -> copying elements from temp array to orignal array

        for(int i=low;i<=high;i++){
            nums[i] = li.get(i-low);
        }
    }

    void mergeSort(int nums[], int low, int high)
    {
        //code here
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
}

// ====================================== Partitioning an Array =================================
// note : below algo works if pivot is not present in the array
    public static void pivotArray(int[] arr, int pivot) {
        int i = 0,j=0;
        while(i < arr.length){
            if( arr[i] > pivot){
                i++;
            }else{
                swap(arr, i , j );
                i++;
                j++;
            }
        }
        for( int val : arr){
            System.out.print(val + " ");
        }
    }

    public static void pivot(int[] arr, int low, int high){
    	int pi = arr[low];
    	int i = low, j = high;
    	while( i < j){
    		while( arr[i] <= pi && i <= high-1) i++;
    		while( arr[j] > pi && j >= low + 1) j--;
    		if( i < j) swap(arr,i,j);
    	}
    	swap(arr,low,j);
    	for( int val : arr){
    		System.out.print(val + " ");
    	}
    }


    // ================================ QUICK SORT COMPLETE ALGO ==================================
    public class Quick_Sort {
    public static void swap(List<Integer> arr, int i, int j){
	int temp = arr.get(i);
	arr.set(i,arr.get(j));
	arr.set(j,temp);
}
    public static int pivot(List<Integer> arr, int low, int high){
    	int pi = arr.get(low);
    	int i = low, j = high;
    	while( i < j){
    		while( arr.get(i) <= pi && i <= high-1) i++;
    		while( arr.get(j) > pi && j >= low + 1) j--;
    		if( i < j) swap(arr,i,j);
    	}
    	swap(arr,low,j);
        return j;
    }
    public static void qs(List<Integer> arr, int low, int high){
        if( low < high) {
            int pi = pivot(arr, low, high);
            qs(arr,low,pi - 1);
            qs(arr,pi+1,high);
        }
    }
    public static List<Integer> quickSort(List<Integer> arr){
        // Write your code here.
        qs(arr, 0, arr.size() - 1);
        return arr;
    }
}
