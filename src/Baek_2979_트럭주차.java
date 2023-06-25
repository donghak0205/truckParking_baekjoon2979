import java.io.IOException;
import java.util.Scanner;

/* [ 구현 ] 트럭주차 백준 2979번 */
public class Baek_2979_트럭주차 {

    public static void main(String[] args) throws IOException {

        int[] arr = new int[100]; //입력받은 숫자대로 배열을 만든다.
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int start = 0;
        int end = 0;
        int min = 999;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            start = sc.nextInt();
            end = sc.nextInt();

            min = Math.min(min, start);
            max = Math.max(max, end);

            //범위별로 값을 증감시키는것
            //why? 범위별로 금액을 체크하기 위해서
            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }


        for (int s = min; s < max; s++) {

            if (arr[s] == 1) {
                sum += 1 * A;
            } else if (arr[s] == 2) {
                sum += 2 * B;
            } else if (3 == 3) {
                sum += arr[s] * C;
            }
        }

        System.out.println(sum);

    }
}

