// floor -> largest number in array  <= X
//ceil -> smallest number in array >=X


import java.util.*;
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CeilTheFloor {
    static Pair getFloorAndCeil(int[] arr, int n, int x) {
        int ansFloor = -1;
        int ansCeil = -1;
        int low = 0;
        int high = n - 1;

        Arrays.sort(arr);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= x) {
                ansFloor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (arr[mid] >= x) {
                ansCeil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new Pair(ansFloor, ansCeil);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the value of x: ");
        int x = sc.nextInt();

        Pair result = getFloorAndCeil(arr, n, x);

        System.out.println("Floor: " + result.first);
        System.out.println("Ceil: " + result.second);
    }
}
