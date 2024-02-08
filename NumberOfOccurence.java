
import java.util.*;
class NumberOfOccurence{
    // code here
    static int firstOccurence(int[] arr,int n,int x){
        int first=-1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                first=mid;
                high=mid-1;
            }else  if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return first;
    }
    static int lastOccurence(int[] arr,int n,int x){
        int last=-1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                last=mid;
                low=mid+1;
            }else if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return last;
    }
    static int count(int[] arr, int n, int x) {
        int First=firstOccurence(arr,n,x);
        int Last=lastOccurence(arr,n,x);
        if(First==-1 || Last==-1){
            return 0;
        }
        return (Last-First)+1;
    }
        public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int x=sc.nextInt();
       int[] arr=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
       }
        System.out.println(count(arr,n,x));
    }
}
