
// it is all about finding the lower bound of the array
// Lower bound -> smallest index such that arr[index]>=K
// upper bound -> smallest index such that arr[index]>k
import java.util.*;
class FirstAndLastOccurence {
    static int lowerBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int upperBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static ArrayList<Integer> find(int[] arr, int n, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int lb = lowerBound(arr, n, x);
        if (lb == n || arr[lb] != x) {
            ans.add(-1);
            ans.add(-1);
        }
        int ub = upperBound(arr, n, x);
        ans.add(lb);
        ans.add(ub);
        return ans;
    }
        public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int x=sc.nextInt();
       int[] arr=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
       }
        System.out.println(find(arr,n,x));
    }
}
