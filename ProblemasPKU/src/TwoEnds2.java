
//* @author: ccQ.SuperSupper
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TwoEnds2 {
 static final int M = 2,N = 1000+2;
 static int value[] = new int[N];
 static int map[][][] = new int[N][N][M],n;
 public static int Get_Num(StreamTokenizer cin) throws Exception{
	cin.nextToken();
	return (int) cin.nval;
 }

 public static void main(String []args) throws Exception{
		
  int i,k=1;
		
  StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
  while(true){
	n = Get_Num(cin);
	if(n==0) break;
		
	for(i=1;i<=n;++i) value[i] = Get_Num(cin);
		
System.out.println("In game "+k+", the greedy strategy might lose by as many as "+solve()+" points.");
	++k;
  }
}

 public static void init_map(){
	int i,j;
	for(i=0;i<=n;++i) for(j=0;j<=n;++j){
		map[i][j][0] = map[i][j][1] = -1;
	}
  }

 public static int max(int a,int b){
	return a>b?a:b;
 }

 public static int get_ans(int left,int right,int p){
  if(map[left][right][p]!=-1)
	return map[left][right][p];
  if(left==right){
	if(p==1) return map[left][right][p] = value[left];
	return map[left][right][p] = 0;
  }
  if(p==1){
return map[left][right][p] = max(get_ans(left,right-1,1-p)+value[right],get_ans(left+1,right,1-p)+value[left]);
  }else{
return map[left][right][p] = (value[right]>value[left]?get_ans(left,right-1,1-p):get_ans(left+1,right,1-p));
 }
}

 public static int solve(){
	int i,k=0;
	init_map();
	for(i=1;i<=n;++i) k+=value[i];
	return get_ans(1,n,1)*2-k;
  }
}
