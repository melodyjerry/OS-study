package Algorithm.Scheduling.template;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * https://blog.csdn.net/L_Miracle/article/details/70570080
 */
public class Awara_OS_FCFS {

    public static int i;
    public double awara[];
    public double awara1[];
    public int process_number;
    public double arrival_time[];
    public double services_time[];
    public double start_time[];
    public double wait_time[];
    public double completion_time[];
    public double turn_around_time[];
    public double turn_around_time_with_weight[];

    private void Set_process_number(int process_nuber) {
        this.process_number = process_nuber;

    }

    private double get_process_number() {
        return process_number;
    }

    private void Set_arrival_time(int arrival_time[]) {
        for (i = 0; i < process_number; i++) {
            this.arrival_time[i] = arrival_time[i];
        }
    }

    private double[] get__arrival_time() {

        for (i = 0; i < process_number; i++) {
            awara[i] = arrival_time[i];
        }
        return awara;
    }

    private void Set_services_time(int services_time[]) {
        for (i = 0; i < process_number; i++) {
            this.services_time[i] = services_time[i];
        }
    }

    private double[] get_services_time() {
        for (i = 0; i < process_number; i++) {
            awara1[i] = services_time[i];
        }
        return awara1;
    }

    private void FCFS() {

        start_time[0] = arrival_time[0];
        completion_time[0] = arrival_time[0] + services_time[0];
        start_time[0] = arrival_time[0];
        turn_around_time[0] = completion_time[0] - arrival_time[0];
        turn_around_time_with_weight[0] = turn_around_time[0]
                / services_time[0];
        for (i = 1; i < process_number; i++) {
            start_time[i] = completion_time[i - 1];
            wait_time[i] = start_time[i] - arrival_time[i];
            completion_time[i] = arrival_time[i] + services_time[i]
                    + wait_time[i];
            turn_around_time[i] = completion_time[i] - arrival_time[i];
            turn_around_time_with_weight[i] = turn_around_time[i]
                    / services_time[i];

        }
        System.out.println("\n：开始时间是： ");
        for (i = 0; i < process_number; i++) {
            System.out.print(start_time[i] + "\t");

        }
        System.out.println("\n等待时间是：");
        for (i = 0; i < process_number; i++) {
            System.out.print(wait_time[i] + "\t");
        }
        System.out.println("\n完成时间是：");

        for (i = 0; i < process_number; i++) {
            System.out.print(completion_time[i] + "\t");
        }
        System.out.println("\n周转时间是：");

        for (i = 0; i < process_number; i++) {
            System.out.print(turn_around_time[i] + "\t");
        }
        System.out.println("\n带权周转时间：");
        for (i = 0; i < process_number; i++) {
            System.out.print(turn_around_time_with_weight[i] + "\t");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("请输入进程数：");
        Awara_OS_FCFS cok = new Awara_OS_FCFS();
        BufferedReader buf = null;
        buf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = null;
        str1 = buf.readLine();
        cok.process_number = (int) Double.parseDouble(str1);
        cok.arrival_time = new double[cok.process_number];
        cok.services_time = new double[cok.process_number];
        cok.completion_time = new double[cok.process_number + 1];
        cok.turn_around_time = new double[cok.process_number + 1];
        cok.start_time = new double[cok.process_number];
        cok.wait_time = new double[cok.process_number];
        cok.turn_around_time_with_weight = new double[cok.process_number];

        String str = null;
        String str2 = null;

        System.out.println("\n请输入各进程到达时间");
        for (i = 0; i < cok.process_number; i++) {
            str = buf.readLine();
            cok.arrival_time[i] = Double.parseDouble(str);
        }

        System.out.println("\n请输入各个进程服务时间");
        for (i = 0; i < cok.process_number; i++) {
            str2 = buf.readLine();
            cok.services_time[i] = Double.parseDouble(str2);

        }
        System.out.println("该进程数为" + cok.process_number);
        System.out.println("\n到达时间为");
        for (i = 0; i < cok.process_number; i++) {
            System.out.print(cok.arrival_time[i] + "\t");
        }
        System.out.println("\n服务时间为：");
        for (i = 0; i < cok.process_number; i++) {
            System.out.print(cok.services_time[i] + "\t");
        }
        cok.FCFS();

    }

}
