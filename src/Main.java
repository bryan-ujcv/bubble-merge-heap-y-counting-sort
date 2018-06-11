import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner miScanner=new Scanner(System.in);
		Random random=new Random();
		System.out.println("de que tamano desea el arreglo");
		int x=miScanner.nextInt();
		double arr[]=new double[x];
		for(int i=0;i<arr.length;i++) {
			int n = (int)(random.nextInt(1000));
			arr[i]=n;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+arr[i]+"] ");
		}
		System.out.println("\n***********************************************************************");
        bubble burbuja = new bubble();
        System.out.println("BUBBLE\n");
        burbuja.sort(arr);
        System.out.println("arreglo ordenado\n");
        burbuja.imprimir(arr);
        final double NSb=1000000000;
        long inicioNSb=System.nanoTime();
        burbuja.sort(arr);
        long duracionNSb=System.nanoTime()-inicioNSb;
        System.out.println("\nlo que se tarda el bubble sort es: "+duracionNSb+" nano segundos");
          
        
        System.out.println("***********************************************************************");
        
        System.out.println("MERGE");
        merge merge = new merge();
        System.out.println("\narreglo ordenado\n");
        merge.imprimir(arr);
        final double NSm=1000000000;
        long inicioNSm=System.nanoTime();
        merge.sort(arr, x, x);
        long duracionNSm=System.nanoTime()-inicioNSm;
        System.out.println("\nlo que se tarda el merge sort es: "+duracionNSm+" nano segundos");

	}

}
class bubble {
	   void sort(double arr[]) {
	        double n = arr.length;
	        for (int i = 0; i < n-1; i++) {
	            for (int j = 0; j < n-i-1; j++) {
	                if (arr[j] > arr[j+1]) {
	                    double temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	            }
	        }
	    }
	   
	    void imprimir(double arr[]) {
	        double n = arr.length;
	        for (int i=0; i<n; ++i) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	 
	}

class merge {
	 void merge(double arr[], int l, int m, int r) {
	        int n1 = m - l + 1;
	        int n2 = r - m;
	        /* arreglos temporales */
	        double izq[] = new double [n1];
	        double der[] = new double [n2];
	 
	        for (int i=0; i<n1; ++i) {
	            izq[i] = arr[l + i];
	            for (int j=0; j<n2; ++j) {
	            	der[j] = arr[m + 1+ j];
	            }
	        }
	
	        int i = 0;
	        int j = 0;
	        int x = l;
	        while (i < n1 && j < n2) {
	            if (izq[i] <= der[j]) {
	                arr[x] = izq[i];
	                i++;
	            }else {
	                arr[x] = der[j];
	                j++;
	            }
	            x++;
	        }
	 
	        while (i < n1) {
	            arr[x] = izq[i];
	            i++;
	            x++;
	        }
	
	        while (j < n2) {
	            arr[x] = der[j];
	            j++;
	            x++;
	        }
	    }
	 
	    void sort(double arr[], int l, int r) {
	        if (l < r) {
	            int m = (l+r)/2;
	 
	            sort(arr, l, m);
	            sort(arr , m+1, r);
	 
	            merge(arr, l, m, r);
	        }
	    }
	 
	    static void imprimir(double arr[]) {
	        double n = arr.length;
	        for (int i=0; i<n; ++i) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	 
	}

