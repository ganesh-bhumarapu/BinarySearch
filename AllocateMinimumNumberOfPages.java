import java.util.*;
class AllocateMinimumNumberOfPages{
    static int countStudents(int[] arr,int pages){
        int students=1;
        int pagesStudent=0;
        for(int i=0;i<arr.length;i++){
            if(pagesStudent+arr[i]<=pages){
                pagesStudent+=arr[i];
            }else{
                students++;
                pagesStudent=arr[i];
            }
        }
        return students;
    }
    static int solve(int[] arr,int N,int M){
        if(M>N){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        int sumPages=0;
        for(int i=0;i<N;i++){
            max=Math.max(max,arr[i]);
            sumPages+=arr[i];
        }
        int low=max;
        int high=sumPages;
        while(low<=high){
            int mid=(low+high)/2;
            int students=countStudents(arr,mid);
            if(students>M){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]+=sc.nextInt();
        }
        System.out.println(solve(arr,N,M));
    }
}
