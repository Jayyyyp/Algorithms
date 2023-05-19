package concept;

public class FisanoPeriod {
    /* m이 주어지면 피보나치 수열을 계산하면서
     * m으로 나눈 나머지를 계산하는 피사노 주기
     * 피보나치 수열이 처음으로 0,1이 되는 순간을 찾는 것이 피사노 주기
     * */
    static int pisanoPeriod(int m) {
        int a = 0, b = 1, c = a + b;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) return i + 1;
        }
        return -1;
    }

    static int fibonacciModulo(int n, int m) {
        int remainder = n % pisanoPeriod(m); // n을 피사노 주기로 나눈 나머지

        int first = 0;
        int second = 1;

        int res = remainder;

        for (int i = 1; i < remainder; i++) {
            res = (first + second) % m;
            first = second;
            second = res;
        }

        return res % m;
    }

    public static void main(String[] args) {
        int n = 6;
        int m = 3;
        System.out.println(fibonacciModulo(n, m));
    }
}
