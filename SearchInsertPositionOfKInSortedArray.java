
// it is all about finding the lower bound of the array
// Lower bound -> smallest index such that arr[index]>=K
// upper bound -> smallest index such that arr[index]>k
import java.util.*;
class SearchInsertPositionOfKInSortedArray{
    static int searchInsertIndex(int[] arr,int n,int K){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=K){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
        public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int K=sc.nextInt();
       int[] arr=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
       }
        System.out.println(searchInsertIndex(arr,n,K));
    }
}
