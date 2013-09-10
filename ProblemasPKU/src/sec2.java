import java.util.Scanner;


public class sec2 {

	public static void main(String[] args){  
        long[] len=new long[35000];  
        long[] squ=new long[35000];  
        Scanner cin=new Scanner(System.in);  
        int caseNum=cin.nextInt();  
        while(cin.hasNext()){  
            int i=1;len[1]=1;squ[1]=1;  
            long pos=cin.nextLong();  
            while(len[i++]<pos){  
                squ[i]=squ[i-1]+getDig(i);  
                len[i]=len[i-1]+squ[i];  
            }  
            //System.out.println(squ[i-1]);  
            if(len[i-1]==pos){  
                System.out.println(i-1);  
            }else{  
                int j=1;  
                while(squ[j++]<(pos-len[i-2])){  
                }  
                //System.out.println(squ[j]);  
                if(squ[j-1]==(pos-len[i-2])){  
                    System.out.println((j-1));  
                }else{  
                    long s=squ[j-1]-(pos-len[i-2]);  
                    while((s--)!=0){  
                        j/=10;  
                    }  
                    System.out.println(j);  
                }  
            }  
        }  
    }  
    static long getDig(int i){  
        long digit=1;  
        while((i/10)!=0){  
            i/=10;  
            digit++;  
        }  
        return digit;  
    }  

}
