package AlgoritmosDeGrafos;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ConjuntosDisyuntos {

	static final int MAX = 10000;  //maximo numero de vertices
	static int padre[];   //Este arreglo contiene el padre del i-esimo nodo
	static int rango[];   //profundidad de cada vertice
	
	//Metodo de inicializacion
	static void MakeSet( int n ){
		padre=new int[n];
		rango=new int[n];
	    for( int i = 0 ; i < n ; ++i ){
	        padre[ i ] = i;      //Inicialmente el padre de cada vertice es el mismo vertice
	        rango[ i ] = 0;      //Altura o rango de cada vertice es 0
	    }
	}

	//Metodo para encontrar la raiz del vertice actual X
	static int Find( int x ){
	    if( x == padre[ x ] ){          //Si estoy en la raiz
	        return x;                   //Retorno la raiz
	    }
	    //else return Find( padre[ x ] ); //De otro modo busco el padre del vertice actual, hasta llegar a la raiz.
	    else return padre[ x ] = Find( padre[ x ] ); //Compresion de caminos
	}

	//Metodo para unir 2 componentes conexas
	static void Union( int x , int y ){
	    int xRoot = Find( x );    //Obtengo la raiz de la componente del vertice X
	    int yRoot = Find( y );    //Obtengo la raiz de la componente del vertice Y
	    padre[ xRoot ] = yRoot;   //Mezclo ambos arboles o conjuntos, actualizando su padre de alguno de ellos como la raiz de otro
	}

	//Metodo para unir 2 componentes conexas usando sus alturas (rangos)
	static void UnionbyRank( int x , int y ){
	    int xRoot = Find( x );    //Obtengo la raiz de la componente del vertice X
	    int yRoot = Find( y );    //Obtengo la raiz de la componente del vertice Y
	    if( rango[ xRoot ] > rango[ yRoot ] ){ //en este caso la altura de la componente del vertice X es
	                                           //mayor que la altura de la componente del vertice Y.
	        padre[ yRoot ] = xRoot;            //el padre de ambas componentes sera el de mayor altura
	    }
	    else{                    //en este caso la altura de la componente del vertice Y es mayor o igual que la de X
	        padre[ xRoot ] = yRoot;            //el padre de ambas componentes sera el de mayor altura
	        if( rango[ xRoot ] == rango[ yRoot ] ){ //si poseen la misma altura
	            rango[ yRoot ]++;              //incremento el rango de la nueva raiz
	        }
	    }
	}

	static int root[] = new int[ MAX ]; //tendra las raices de las componentes conexas luego de aplicar el metodo
	static int numComponentes; //variable para el numero total de componentes conexas
	//Metodo para obtener el numero de componentes conexas luego de realizar las conexiones respectivas
	static int getNumberConnectedComponents( int n ){
	    numComponentes = 0;
	    for( int i = 0 ; i < n ; ++i ){
	        if( padre[ i ] == i ){    //Si el padre del vertice i es el mismo vertice entonces es raiz
	        //if( Find( i ) == i ){   //podemos usamos find para el mismo proposito y
	                                  //para que se realice compresion de caminos
	            root[ numComponentes++ ] = i;  //almaceno la raiz de cada nueva componente
	           // numComponentes++;
	        }
	    }
	    return numComponentes;
	}

	static int numVertices[];   //almacenara la cantidad de vertices para la i-esima raiz.
	//Metodo para obtener la raiz y el numero de vertices de cada componente conexa
	//sera necesario primero tener la cantidad de componentes conexas
	//podemos llamar 1ero al metodo getNumberConnectedComponents o incluir porcion de su codigo en este
	static void getNumberNodes( int n ){
		numVertices=new int[n];
	    Arrays.fill( numVertices, 0 );     //inicializo mi contador de vertices
	    for( int i = 0 ; i < n ; ++i ){
	        numVertices[ Find( i ) ]++;    //incremento la raiz del vertice i
	    }
	    for( int i = 0 ; i < numComponentes ; ++i ){
	        System.out.printf("Componente %d: Raiz = %d , Nro nodos = %d.\n" , i + 1 , root[ i ] , numVertices[ root[ i ] ] );
	    }
	}

	//Metodo que me determina si 2 vertices estan o no en la misma componente conexa
	static boolean sameComponent( int x , int y ){
	    if( Find( x ) == Find( y ) ) return true;   //si poseen la misma raiz
	    return false;
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	  int V , E , origen , destino;

	    Scanner sc = new Scanner( System.in );  
	    V = sc.nextInt(); E = sc.nextInt();    //tengamos numero de vertices y aristas
	    MakeSet( V );                          //inicializamos los conjuntos
	    for( int i = 0 ; i < E ; ++i ){
	        origen = sc.nextInt(); destino = sc.nextInt();
	        UnionbyRank( origen , destino );  //union de elementos
	    }
	    System.out.printf("El numero de componentes conexas es: %d\n" , getNumberConnectedComponents( V ) );
	    getNumberNodes( V );

	}

}
