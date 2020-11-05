package Thread;

/**
 * 阶乘和计算线程
 */
public class FactorialSumThread extends Thread{
    static int sum = 0; //存储阶乘和
    static int schedule = 0; // 存储计算进度
    static String strSum = ""; //存储阶乘和的计算过程的字符串
    static String strResult = ""; //存储阶乘和的结果的字符串

    /**
     * 计算每一个阶乘
     * @param n
     * @return fac
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
     * @param level
     * @return sum
     */
    public static int Sum(int level){
//        int sum = 0;
        for (int i = 1; i <= level; i++) {
            sum += Factorial(i);
            System.out.println(i + "阶层和 =\t" + sum);
        }
        return sum;
    }

    /**
     * 有参构造子
     * 初始化线程名
     * @param name
     */
    public FactorialSumThread(String name) {
        super(name);
    }

    /**
     * 重写run方法
     * 线程的操作主体
     */
    @Override
    public void run() {
//        Sum(12);
        for (int i = 1; i <= 12; i++) {
            schedule++;
            sum += Factorial(i);
            System.out.println(i + "阶层和 =\t" + sum);
            strResult = String.valueOf(sum);
            //存储阶乘和的计算过程：1！+2！+...+12！
            if(i == 1) {
                strSum = i + "!";
            } else {
                strSum = strSum + "+" + i + "!";
            }
            try {
//            threadSleep("1-2"); //threadSleep()中/2了，最后变成了随机睡眠0.5-1秒
                int millis = (int) (Math.random() * 500 + 500); // 随机休眠0.5-1秒
                Thread.sleep(millis); //Math.random()随机选取大于等于0.0且小于1.0的伪随机
                System.out.println("随机休眠了 " + millis + " 毫秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 睡眠n-m秒
     * @param time 1-2
     */
    public static void threadSleep(String time){
        //1-6
        String[] split = time.split("-");
        int first = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[1]);
        try {
//            int temp = (first+(int)(Math.random()*(second-first)))*1000;
//            Thread.sleep((first+(int)(Math.random()*(second-first)))*1000);
            Thread.sleep((first+(int)(Math.random()*(second-first)))*500); //变成了随机睡眠0.5-1秒
//            Thread.sleep(temp);
//            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入最高阶层数n= ");
//        int n = sc.nextInt();
        new FactorialSumThread("阶乘和").start();
//        System.out.println("\n最高" + n + "阶的阶层和 = " + Sum(n)); // 12  522956313
//        new Thread.FactorialGUI("GUI").start();
//        sc.close();
    }
}
