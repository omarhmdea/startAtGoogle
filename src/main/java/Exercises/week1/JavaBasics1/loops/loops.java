package Exercises.week1.JavaBasics1.loops;

public class loops {
    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int num = 2;
        dividedWithoutRemainderFori(numbers, num);
        dividedWithoutRemainderForEach(numbers, num);
        dividedWithoutRemainderWhile(numbers, num);
    }

    public static void dividedWithoutRemainderFori(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i]);
            }

        }
    }

    public static void dividedWithoutRemainderForEach(int[] arr, int num) {

        for (int element :
                arr) {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        }

    }

    public static void dividedWithoutRemainderWhile(int[] arr, int num) {

        int i = 0;
        while (i < arr.length) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i]);
            }
            i++;
        }

    }
}
