package Thread;

/**
 * �׳˺ͼ����߳�
 */
public class FactorialSumThread extends Thread{
    static int sum = 0; //�洢�׳˺�
    static int schedule = 0; // �洢�������
    static String strSum = ""; //�洢�׳˺͵ļ�����̵��ַ���
    static String strResult = ""; //�洢�׳˺͵Ľ�����ַ���

    /**
     * ����ÿһ���׳�
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
     * ���
     * @param level
     * @return sum
     */
    public static int Sum(int level){
//        int sum = 0;
        for (int i = 1; i <= level; i++) {
            sum += Factorial(i);
            System.out.println(i + "�ײ�� =\t" + sum);
        }
        return sum;
    }

    /**
     * �вι�����
     * ��ʼ���߳���
     * @param name
     */
    public FactorialSumThread(String name) {
        super(name);
    }

    /**
     * ��дrun����
     * �̵߳Ĳ�������
     */
    @Override
    public void run() {
//        Sum(12);
        for (int i = 1; i <= 12; i++) {
            schedule++;
            sum += Factorial(i);
            System.out.println(i + "�ײ�� =\t" + sum);
            strResult = String.valueOf(sum);
            //�洢�׳˺͵ļ�����̣�1��+2��+...+12��
            if(i == 1) {
                strSum = i + "!";
            } else {
                strSum = strSum + "+" + i + "!";
            }
            try {
//            threadSleep("1-2"); //threadSleep()��/2�ˣ�����������˯��0.5-1��
                int millis = (int) (Math.random() * 500 + 500); // �������0.5-1��
                Thread.sleep(millis); //Math.random()���ѡȡ���ڵ���0.0��С��1.0��α���
                System.out.println("��������� " + millis + " ����");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ˯��n-m��
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
            Thread.sleep((first+(int)(Math.random()*(second-first)))*500); //��������˯��0.5-1��
//            Thread.sleep(temp);
//            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("��������߽ײ���n= ");
//        int n = sc.nextInt();
        new FactorialSumThread("�׳˺�").start();
//        System.out.println("\n���" + n + "�׵Ľײ�� = " + Sum(n)); // 12  522956313
//        new Thread.FactorialGUI("GUI").start();
//        sc.close();
    }
}
