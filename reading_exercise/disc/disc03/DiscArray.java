/** week3 disc array codes.
 *  @author prad
 */
public class DiscArray {

    public static int[] insert(int[] arr, int item, int position) {
        int i = position;
        if (i > arr.length) {
            i = arr.length;
        }
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, i);
        newArr[i] = item;

        if (position < arr.length) {
            System.arraycopy(arr, i, newArr, i + 1, arr.length - i);
        }

        return newArr;
    }

    public static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 1;
            j -= 1;
        }
    }

    public static int[] replicate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int[] newArr = new int[sum];
        int newI = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            while (count > 0) {
                newArr[newI] = arr[i];
                count -= 1;
                newI += 1;
            }
        }
        return newArr;
    }

    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i++) {
            totalLength += x[i].length;
        }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                a[aIndex] = x[i][j];
                aIndex += 1;
            }
        }

        return a;
    }
}
