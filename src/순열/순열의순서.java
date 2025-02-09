package 순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 순열의순서 {

    public static long factorial(int n) {
        long fact = 1;
        for(int i=1;i<=n;i++) {
            fact *= i;
        }
        return fact;
    }

    public static void findPermutation(int n, long k) {
        // n의 개수가 주어졌고, K의 개수가 주어졌어 생각할 건 (n-1)! 로 k를 나눌 것 몫은 index, 나머지는 k의 대입
        //순열의 요소를 생성
        ArrayList<Integer> remaining = new ArrayList<Integer>();
        for(int i=1;i<=n;i++) {
            remaining.add(i);
        }

        k--;

        for(int i=1; i<=n;i++ ) {
            int index = (int) (k / factorial(n-i));
            k %= factorial(n-i);
            System.out.print(remaining.get(index) + " ");
            remaining.remove(index);
        }
    }

    public static void findK(int n, int[] permutation) {
        ArrayList<Integer> remaining = new ArrayList<Integer>();
        for(int i=1;i<=n;i++) {
            remaining.add(i);
        }
        long sum = 0;
        for(int i=0;i<n;i++) {
            int elem = permutation[i];
            int index = Collections.binarySearch(remaining, elem);
            remaining.remove(index);
            sum += index * factorial((n-1-i));
        }
        sum++; //k+1

        System.out.println(sum);
    }

    // 첫번 째 줄 N의 개수 입력
    // 두번 째 줄 1 일 경우 K(몇번 째 순열)  2 일 경우 임의의 순열을 나타내는 N개의 수를 입력받는다.
    // 출력 1 일 경우 K 번째에 해당하는 순열 출력, 2 일 경우 순열의 순서를 출력
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());

        int cond = Integer.parseInt(st.nextToken());

        //k번 째 순열 찾기
        if(cond == 1){
            long K = Long.parseLong(st.nextToken());
            findPermutation(N, K);
        }

        //임의 순열의 순서 찾기
        if(cond == 2){
            int[] permutation = new int[N];
            for(int i=0;i<N;i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            findK(N, permutation);
        }
    }
}
