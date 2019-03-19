import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;


public class fengzhuang {
	//封装方法
	//功能一
	public String[] one(TreeMap<String,Integer> map,String str){
		TreeMap<String,Integer> map1 = new TreeMap<String,Integer>();
		
		String[] s2=str.split(",");
		
		for (int i = 0; i < s2.length; i++) {
			for(Entry<String,Integer> entry: map.entrySet()) {					
			    if(s2[i].equals(entry.getKey())){
			    	map1.put(entry.getKey(),entry.getValue());
			    	System.out.println(entry.getKey()+"=="+entry.getValue());
			    	break;
			    }
		   }
	  }
	return s2;

		
	}
	//功能3
	public void three(TreeMap<String,Integer> map){
		
		BufferedWriter bw = null;
		try {
			File file = new File("result.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}			
        Iterator<String> it1 = map.keySet().iterator();
        while(it1.hasNext())
        {
        	String key = (String) it1.next();
        	Integer value = map.get(key);	        	
        	try {
				bw.write(key+"="+value+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

        }
         System.out.println("存放成功！！！");
    }

		
	}

