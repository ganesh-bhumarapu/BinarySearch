
// floor -> largest number in array  <= X
//ceil -> smallest number in array >=X

import java.util.*;
class FloorInSortedArray{
    static int findFloor(long arr[], int n, long x)
    {
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=x){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long x =sc.nextLong();
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(findFloor(arr,n,x));
    }
}
