public class ReadThread extends Thread {//读取阶乘
    ThreadFrame tf;
    ReadThread(ThreadFrame tf){//初始化
        this.tf=tf;
    }
    @Override
    public void run() {
// TODO Auto-generated method stub
        while(true){
            tf.textArea.setText(ComputeThread.stringSum);//将阶乘和的过程显示到文本域中
            tf.textFile.setText(ComputeThread.stringResult);//将阶乘和结果显示到文本框中
            tf.jpb.setValue(ComputeThread.i);//在面板上的进度条中显示计算进度
            try{
                Thread.sleep(100);//0.1秒读取一次线程
            }catch (Exception e) {
// TODO: handle exception
            }
        }
    }
}