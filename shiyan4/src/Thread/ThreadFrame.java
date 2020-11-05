package Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadFrame implements ActionListener {
    JFrame jframe; //��������
    Panel panel; //�������
    Label label_title; //������ǩ
    Label label_1;
    Label label_2;
    Label label_3;
    TextField textField; //�����ı���
    TextArea textArea; //�����ı���
    Button btn; //������ť
    JProgressBar jpb; //����������

    /**
     * �޲ι�����
     * ����ʵ�崰��
     */
    public ThreadFrame() {
        //������۷��
        JFrame.setDefaultLookAndFeelDecorated(true);
//        jframe.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });

        //��������
        jframe = new JFrame("���߳�ʵ�ֽ׳˼���");
        jframe.setBounds(600, 100, 600, 400);//���ô�С
        jframe.setVisible(true);//��ʾ����
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������

        //�������
        panel=new Panel();
        panel.setBackground(Color.white);//���ñ�����ɫ
        panel.setLayout(null);//ȡ��Ĭ�ϲ���
        jframe.add(panel);

        //������ǩ
        label_title=new Label("���߳�ʵ�ֽ׳˼���");
        label_1=new Label("������̣�");
        label_2=new Label("��ȡ�����");
//        label_3=new Label("������ȣ�");
        label_title.setBounds(jframe.size().width/2-75, 10, 200, 50);
        label_1.setBounds(30, 100, 60, 20);
        label_2.setBounds(30, 160, 60, 20);
//        label_3.setBounds(30, 220, 60, 20);
        label_title.setFont(new Font("����", 1, 16));//��������
        panel.add(label_title);
        panel.add(label_1);
        panel.add(label_2);
//        panel.add(label_3);

        //�����ı���
        textArea=new TextArea();
        textArea.setBounds(100, 80, 360, 60);
        textArea.setEditable(false);//���ɱ༭
        panel.add(textArea);

        //���������ı���
        textField=new TextField("0");
        textField.setBounds(textArea.getX(), 160, textArea.size().width, 20);
        textField.setEditable(false);//���ɱ༭
        panel.add(textField);

        //������ť
        btn=new Button("��ʼ����");
        btn.setBounds(jframe.size().width/2-35, 270, 70, 30);
        panel.add(btn);
        btn.addActionListener(this);//��Ӽ�����

        //����������
        jpb=new JProgressBar();
        jpb.setBounds(textArea.getX(), textField.getY()+textField.size().height+20, textField.size().width, 20);
        jpb.setMaximum(12);//�������ֵ
        panel.add(jpb);
    }

    /**
     * ��ʼ���㰴ť �İ��¼�
     * ��д ���ղ����¼����������ӿ�
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //���ý׳˺ͼ����߳�
        new Thread(new FactorialSumThread("�׳˺ͼ����߳�")).start();
//        FactorialSumThread fst = new FactorialSumThread("�׳˺ͼ����߳�");
//        Thread Tfst = new Thread(fst);

        //���ö�ȡ�߳�
        new Thread(new ReadFactorialSumThread("��ȡ�߳�", this)).start();
//        ReadFactorialSumThread rfst = new ReadFactorialSumThread("��ȡ�߳�");
//        Thread Trfst = new Thread(rfst);
    }
}
