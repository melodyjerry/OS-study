package Thread;

public class ReadFactorialSumThread extends Thread{
    ThreadFrame tf; //����ThreadFrame��ʵ��

    /**
     * @param name
     * @param tf
     */
    public ReadFactorialSumThread(String name, ThreadFrame tf) {
        super(name);
        this.tf = tf;
    }

    /**
     * ��д
     */
    @Override
    public void run() {
        while (true) {
            tf.textArea.setText(FactorialSumThread.strSum);
            tf.jpb.setValue(FactorialSumThread.schedule);
            tf.textField.setText(FactorialSumThread.strResult);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
