
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prueba{
    
    public static void main(String[] args) throws IOException {
        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int k = Integer.parseInt(br.readLine());
    String cadena = br.readLine();
    String line=cadena;
    for (int i = 1; i < k; i++) {
             cadena=cadena+cadena;
        }
    
    char[] c = cadena.toCharArray();
    
    int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cont=0;
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < c.length; j++) {
                if(String.valueOf(c[j]).equals(val[1])){
                    cont++;
                }
                if(cont==Integer.parseInt(val[0])){
                    c[j]=' ';
                    break;
                }
            }
        }        
        for (int i = 0; i < c.length; i++) {
            if(c[i]!=' '){
                System.out.print(c[i]);
            }
        }
        System.out.println();
    }
}
