package by.day17;


public class Task {
    public static void main(String[] args) {

        int[] numbers = {1, 11, 13, 10, 100};

        System.out.println(recursionSum(numbers));
        System.out.println(count7(717771237));

    }

    public static int recursionSum(int[] numbers) {
        int sum;
        if (numbers.length == 1)
            return sum = numbers[numbers.length - 1];
        sum = numbers[numbers.length - 1];
        int[] nums = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, nums, 0, numbers.length - 1);
        sum += recursionSum(nums);

        return sum;
    }

    public static int count7(int n) {
        int count =0;
        String str = String.valueOf(n);
        char m = str.charAt(str.length() - 1);
        if (m == '7') {
            count++;
        }
        if (str.length() == 1)
            return count;

        String str1 = str.substring(0, str.length() - 1);
        return count+ count7(Integer.parseInt(str1));
    }
}

