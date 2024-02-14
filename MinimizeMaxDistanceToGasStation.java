import java.util.*;
class MinimizeMaxDistanceToGasStation{
    static int noOfGasStationsRequired(double dist,int[] stations){
        int count=0;
        double epsilon=1e-9;
        for(int i=1;i<stations.length;i++){
            int numberInBetween=(int)((stations[i]-stations[i-1]));
            count+=numberInBetween;
        }
        return count;
    }
    public static double findSmallestMaxDist(int stations[], int K) {
        int n = stations.length;
        double low = 0;
        double high = 0;
        for (int i = 0; i < n-1; i++) {
            high = Math.max(high, (double) (stations[i + 1] - stations[i]));
        }
        double diff = 1e-9;
        double ans = 0;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int count = noOfGasStationsRequired(mid, stations);
            if (count > K) {
                low = mid;
            } else {
                ans = high;
                high = mid;
            }
        }
        return ans;
    }
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]+=sc.nextInt();
        }
        int K=sc.nextInt();
        System.out.println(findSmallestMaxDist(arr,K));
    }
}
