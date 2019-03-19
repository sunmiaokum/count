import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFrame;


public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	public static TreeMap<String,Integer> map;
	 public static String[] str;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��ʾ
		System.out.println("========Ӣ�ĵ���ͳ��========");
		System.out.println("1.ָ������ͳ��");
		System.out.println("2.��Ƶ��ͳ��");
		System.out.println("3.���е�����������Ƶ��ͳ�ƣ���������뵽result.txt");
		System.out.println("�������ţ�");
		
		 map = new TreeMap<String,Integer>();
		
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		
		//�����ļ�text.txt
	    String line = "src/text.txt";
		File file = new File(line);
		InputStreamReader f = null;						
		try {				 
			f = new InputStreamReader(new FileInputStream(file), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(f);//���뻺����													
			//һ�ζ���һ�У����벻Ϊ��ʱ ���е���ͳ��				 				  
		        try {
					while((line=reader.readLine())!=null){
						line = line.toLowerCase();//���Դ�Сд
						String[] str = line.split("[^a-zA-Z]");//ȥ�������ַ�
						
						for(int i = 0; i<str.length; i++){
							String word = str[i].trim();
							if(map.containsKey(word) &&  word.length() != 0){
								map.put(word, map.get(word)+1);
							}else{
								map.put(word, 1);
							}			        		
					    }
                    }
				} catch (IOException e) {
					e.printStackTrace();
				}		   
		  //������
		   //     Iterator<String> iterator=map.keySet().iterator();
			//	while(iterator.hasNext()){
			//		System.out.println(iterator.next());
		//      }
		        //����
		       // for(Entry<String,Integer> entry: map.entrySet()) {										    					    	
			    //	System.out.println(entry.getKey()+"=="+entry.getValue());					    
				//    }

		
		if(s==1){
			//1.ָ������ͳ�ƹ���
//		     ͳ�������еĵ��ʵĸ���   
			
			System.out.println("��������Ҫ���ҵĵ���,�ö��Ÿ���");
			String s1=sc.next();
			//�����෽��
			fengzhuang f1=new fengzhuang();
			str=f1.one(map, s1);//s1��ָ������  map�����еĵ���
			
			Main s3=new Main();
			s3.setVisible(true);
			
			
			
		}else if(s==2){
			//2.��Ƶ��ͳ�ƹ���
			
		}else if(s==3){
			//3.���е�����������Ƶ��ͳ��
			//������ķ���3
			fengzhuang f1=new fengzhuang();
			f1.three(map);
		}


	}
	//����ͼ
	public Main(){
		super();
		setTitle("����ͼ");
		setBounds(3, 200, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	 @Override
	  public void paint(Graphics g){
		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;//����ͼ��߽�
		int topMargin = 50;//����ͼ�ϱ߽�
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height-topMargin;
		int rulerStep = ruler/20;//����ǰ�ĸ߶�����Ϊ20����λ
		g2.setColor(Color.WHITE);//���ư�ɫ����
		g2.fillRect(0, 0, Width, Height);//���ƾ���ͼ
		g2.setColor(Color.LIGHT_GRAY);
		for(int i=0;i<rulerStep;i++){
			g2.drawString((400-20*i)+"��", 8, topMargin+rulerStep*i);//����Y���ϵ�����
		}
		g2.setColor(Color.orange);
		int m=0;
		for(int i = 0;i<str.length;i++){
			int value = map.get(str[i]);
			int step = (m+1)*40;//����ÿ������ͼ��ˮƽ���Ϊ40
			g2.fillRoundRect(leftMargin+step*2,Height-value, 40, value, 40, 10);//����ÿ����״��
			g2.drawString(str[i], leftMargin+step*2, Height-value-5);	//��ʶÿ����״��		
			m++;
		}
	  }     


}
