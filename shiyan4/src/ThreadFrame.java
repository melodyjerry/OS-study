import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadFrame implements ActionListener {//�������
    JFrame jframe;//��������
    Panel panel;//�������
    Label label_title;//������ǩ
    Label label_1;
    Label label_2;
    Label label_3;
    TextField textFile;//�����ı���
    TextArea textArea;//�����ı���
    Button btn;//������ť
    JProgressBar jpb;//����������


    ThreadFrame(){
//��������
        jframe=new JFrame("�߳�");//���ô�������
        jframe.setBounds(600, 100, 400, 400);//���ô�С
        jframe.setVisible(true);//���ÿμ�
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������

//�������
        panel=new Panel();
        panel.setBackground(Color.white);//���ñ�����ɫ
        panel.setLayout(null);//ȡ��Ĭ�ϲ���
        jframe.add(panel);

//������ǩ
        label_title=new Label("���߳�ʵ��");
        label_1=new Label("�����̣߳�");
        label_2=new Label("������ȣ�");
        label_3=new Label("�����ȡ��");
        label_title.setBounds(jframe.size().width/2-50, 10, 100, 50);
        label_1.setBounds(30, 100, 60, 20);
        label_2.setBounds(30, 160, 60, 20);
        label_3.setBounds(30, 220, 60, 20);
        label_title.setFont(new Font("����", 1, 16));//��������
        panel.add(label_title);
        panel.add(label_1);
        panel.add(label_2);
        panel.add(label_3);

//�����ı���
        textArea=new TextArea();
        textArea.setBounds(100, 80, 200, 60);
        textArea.setEditable(false);//���ɱ༭
        panel.add(textArea);

//���������ı���
        textFile=new TextField("0");
        textFile.setBounds(textArea.getX(), 220, textArea.size().width, 20);
        textFile.setEditable(false);//���ɱ༭
        panel.add(textFile);

//������ť
        btn=new Button("��ʼ����");
        btn.setBounds(jframe.size().width/2-35, 270, 70, 30);
        panel.add(btn);
        btn.addActionListener(this);//��Ӽ�����

//����������
        jpb=new JProgressBar();
        jpb.setBounds(textArea.getX(), textArea.getY()+textArea.size().height+10, textArea.size().width, 40);
        jpb.setMaximum(30);//�������ֵ
        panel.add(jpb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//��ť����¼�
// TODO Auto-generated method stub
//���ü����߳�
        ComputeThread ct=new ComputeThread();
        Thread tc=new Thread(ct);
//���ö�ȡ�߳�
        ReadThread rt=new ReadThread(this);
        Thread tr=new Thread(rt);
//��ʼ�߳�
        tc.start();
        tr.start();
    }
}