package Thread;

import java.util.Scanner;

public class FactorialSum {
    /**
     * 计算每一个阶乘
     */
    public static int Factorial(int n){
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }

    /**
     * 求和
     */
    public static int Sum(int level){
        int sum = 0;
        for (int i = 1; i <= level; i++) {
            sum += Factorial(i);
            System.out.println(i + "阶层和 =\t" + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入最高阶层数n= ");
        int n = sc.nextInt();
        System.out.println("\n最高" + n + "阶的阶层和 = " + Sum(n)); // 12  522956313
        sc.close();
    }
}
