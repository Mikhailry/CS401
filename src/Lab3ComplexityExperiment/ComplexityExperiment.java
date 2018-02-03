package Lab3ComplexityExperiment;

import java.util.Date;
import java.util.Timer;

public class ComplexityExperiment {
    public static void main (String args []) throws InterruptedException {
        run_method_A(250);
        run_method_A(500);
        run_method_A(1000);
        run_method_A(2000);
        run_method_A(10000);
        run_method_A(100000);
        System.out.println();
        run_method_B(250);
        run_method_B(500);
        run_method_B(1000);
        run_method_B(2000);
        run_method_B(100000);
        System.out.println();
        run_method_C(250);
        run_method_C(500);
        run_method_C(1000);
        run_method_C(2000);
        run_method_C(100000);
        System.out.println();
    }

    public static void run_method_A(int n) {
        int i = 0;
        double start, end;
        start = System.currentTimeMillis();
        methodA(n);
        end = System.currentTimeMillis() - start;
        System.out.println("methodA(n = " + n + ") time = " + end + "ms");
    }
    public static void run_method_B(int n) {
        int i = 0, loop = 1000;
        double start, end;
        start = System.currentTimeMillis();
        for (i = 0; i < loop; i++) {//n
            methodB(n);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("methodB(n = " + n + ") time = " + end/loop + "ms");
    }
    public static void run_method_C(int n) {
        int i = 0;
        double start, end;
        start = System.currentTimeMillis();
        methodC(n);
        end = System.currentTimeMillis() - start;
        System.out.println("methodC(n = " + n + ") time = " + end + "ms");
    }
    public static void methodA (int n){
        int i = 0;//1
        int j = 0;//1
        int k = 0;//1
        int total = 0;//1
        while (i<n){//n
            while (j<n){//n
                while (k<n) {//n
                    total++;//1
                    k++;//1
                }
                k=0;//1
                j++;//1
            }
            j=0;//1
            i++;//1
        }
    }

    public static void methodB (int n){
        int i = 0;//1
        int j = 0;//1
        int total = 0;//1
        while (i<n){//n
            while (j<n){//n
                total++;//1
                j++;//1
            }
            i++;//1
        }
    }
    public static void methodC (int n){
        int i = 0;//1
        int j = 0;//1
        int total = 0;//1
        j = n;//1
        while ((j = j/2) > 0) {//log(n)
            for (i = 0; i < 100*n; i++)//n
                total++;
        }
    }

}
