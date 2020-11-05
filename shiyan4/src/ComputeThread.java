public class ComputeThread extends Thread {//计算阶乘
    double sum=0;//存储阶乘和
    static int i=0;//存储阶乘和进度
    static String stringSum="";//存储阶乘和的字符串
    static String stringResult="";//存储阶乘结果的字符串

    double method(int n){//计算阶乘
        double result=1;//阶乘结果
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }

    @Override
    public void run() {
// TODO Auto-generated method stub

        while(i<30){//计算阶乘和
            i++;
            sum+=method(i);
            stringResult=String.valueOf(sum);//将阶乘和存储到字符串中
            if(i!=1){//显示阶乘和的过程：1！+2！+...+30！
                stringSum=stringSum+"+"+i+"!";
            }else{
                stringSum=i+"!";
            }
            try{//0.5-1秒读取一次线程
                Thread.sleep((int)(Math.random()*500+500));
            }catch(InterruptedException ex){

            }

        }

    }
}