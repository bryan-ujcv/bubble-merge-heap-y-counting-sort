import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner miScanner=new Scanner(System.in);
		Random random=new Random();
		System.out.println("de que tamano desea el arreglo");
		int x=miScanner.nextInt();
		int arr[]=new int[x];
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
        
        System.out.println("***********************************************************************");
        
        System.out.println("HEAP\n");
        heap heap = new heap();
        System.out.println("arreglo ordenado\n");
        heap.imprimir(arr);
        final double NSh=1000000000;
        long inicioNSh=System.nanoTime();
        heap.sort(arr);
        long duracionNSh=System.nanoTime()-inicioNSh;
        System.out.println("\nlo que se tarda el heap sort es: "+duracionNSh+" nano segundos");
        
        System.out.println("***********************************************************************");
        
        System.out.println("COUNTING\n");
        counting counting = new counting();
        System.out.println("arreglo ordenado\n");
        counting.imprimir(arr);
        final double NSc=1000000000;
        long inicioNSc=System.nanoTime();
        counting.sort(arr);
        long duracionNSc=System.nanoTime()-inicioNSc;
        System.out.println("\nlo que se tarda el counting sort es: "+duracionNSc+" nano segundos");

	}

}
class bubble {
	   void sort(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n-1; i++) {
	            for (int j = 0; j < n-i-1; j++) {
	                if (arr[j] > arr[j+1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	            }
	        }
	    }
	   
	    void imprimir(int[] arr) {
	        int n = arr.length;
	        for (int i=0; i<n; ++i) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	 
	}

class merge {
	 void merge(int[] arr, int l, int m, int r) {
	        int n1 = m - l + 1;
	        int n2 = r - m;
	        /* arreglos temporales */
	        int izq[] = new int [n1];
	        int der[] = new int [n2];
	 
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
	 
	    void sort(int[] arr, int l, int r) {
	        if (l < r) {
	            int m = (l+r)/2;
	 
	            sort(arr, l, m);
	            sort(arr , m+1, r);
	 
	            merge(arr, l, m, r);
	        }
	    }
	 
	    static void imprimir(int[] arr) {
	        double n = arr.length;
	        for (int i=0; i<n; ++i) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	 
	}

class heap {
	public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, n, i);
        }
 
        for (int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heap(arr, i, 0);
        }
    }
	
	void heap(int arr[],int n,int i) {
        int padre = i;  
        int hijoizq = (2*i) + 1;  
        int hijoder = (2*i) + 2;  
 
        if (hijoizq < n && arr[hijoizq] > arr[padre]) padre = hijoizq;
 
        if (hijoder < n && arr[hijoder] > arr[padre]) padre = hijoder;
 
        if (padre != i) {
            int swap = arr[i];
            arr[i] = arr[padre];
            arr[padre] = swap;
            heap(arr, n, padre);
        }
    }
 
    static void imprimir(int[] arr) {
        double n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
 
}

class counting{
	 
	  public  int[] sort(int[] arr) {
	     
	   int [] aux = new int[arr.length];
	 
	    
	    int min = arr[0];
	    int max = arr[0];
	    for (int i = 1; i < arr.length; i++) {
	      if (arr[i] < min) {
	        min = arr[i];
	      } else if (arr[i] > max) {
	        max = arr[i];
	      }
	    }
	 
	    
	    int[] counts = new int[max - min + 1];
	 
	    
	    for (int i = 0;  i < arr.length; i++) {
	      counts[arr[i] - min]++;
	    }
	 
	    
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	  
	    for (int i = arr.length - 1; i >= 0; i--) {
	        aux[counts[arr[i] - min]--] = arr[i];
	    }
	 
	    return aux;
	  }
	  void imprimir(int[] arr) {
	        int n = arr.length;
	        for (int i=0; i<n; ++i) {
	            System.out.print(arr[i]+" ");
	        }
	        System.out.println();
	    }
	  
 }


