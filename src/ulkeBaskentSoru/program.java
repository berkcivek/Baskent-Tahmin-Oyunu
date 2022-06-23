package ulkeBaskentSoru;

import java.io.*;
import java.util.*;

public class program {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
              
        FileInputStream fileStream = new FileInputStream("ulkelerVeBaskent.txt");
        DataInputStream dataStream = new DataInputStream(fileStream);
        BufferedReader buffReader =  new BufferedReader(new InputStreamReader(dataStream));
        Random secim = new Random();
                
        String[] [] ulkeler = new String[30] [2];
               
        for (int satir = 0; satir < ulkeler.length; satir++) {
            
            ulkeler[satir] = buffReader.readLine().split(" ");
            
        }
        buffReader.close();
        
        int dogruCevap = 0;  
        int[] secilenUlkeler = new int[10];
        Scanner input = new Scanner(System.in);
        int kontrol = 0;
        for (int i = 0; i < 10; i++)        	
        {                  	    
        	int tmp=secim.nextInt(30);
        	for(int j = 0; j<i+1;j++)
        	{        		    		
        		if(secilenUlkeler[j] == tmp)
        		{
        			kontrol = 0;
        			j=i+1;
        		}
        		else
        			kontrol=1;		
        	}
        	if(kontrol == 1) {
        		secilenUlkeler[i]=tmp;
        	}
        	else
        		i=0;
        }
        String verilenCevap;
              
        for (int i = 0; i < 10; i++) {
            System.out.print(ulkeler[secilenUlkeler[i]] [0] + "'nin baskenti neresidir?: ");
            verilenCevap = input.nextLine();
            verilenCevap= verilenCevap.substring(0,1).toUpperCase()+verilenCevap.substring(1).toLowerCase();
            
            if (ulkeler[secilenUlkeler[i]] [1].equals(verilenCevap)) {
                System.out.println("	Dogru Cevap!");
                dogruCevap++;
            }else {
                System.out.println("	Yanlis, dogru cevap <" + ulkeler[secilenUlkeler[i]] [1] +">");
            }
        }
        System.out.println("Verilen Dogru Cevap Sayisi : " + dogruCevap);        
    }
}
