package geeks.dynamic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//Largest Sum Continuous SubArray Problem;
public class Kadane {

		public static void main (String[] args) throws IOException
		 {
		    //Scanner sc=new Scanner(System.in);
			//buffered reader is more faster then scanner most of the time. so better use buffered reader;
			BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		    int t=Integer.parseInt(sc.readLine());
		    while(t-->0){
		        int n=Integer.parseInt(sc.readLine());
		        String[] a=sc.readLine().trim().split(" ");
//		        for(int i=0;i<n;i++){
//		            a[i]=sc.read();
//		        }
		        int maxSum=Integer.parseInt(a[0]);
		        int sum=maxSum;
		        for(int i=1;i<n;i++){
		            sum+=Integer.parseInt(a[i]);
		            if(sum<0)
		                sum=0;
		            else if(sum>maxSum)
		                maxSum=sum;
		        }
		         System.out.println(maxSum);
		    }
		 }
	}

//73 52 -53 -24 90 1 -75 41 -8 30 -16 -5 -36 -74 20 91 -14 -40 60 -38 -49 -63 48 -48 53 14 89 94 -48 -83 -85 -69 21 -37 7 -37 16 -16 -96 -92 -86 -60 -45 -22 -34 28 -31 52 88 81 -86 91 -81 15 -57 24 -71 -68 -29 -67 -99 -14 -36 -26 1 23 37 -83 -92 -6 77 74 34 -67 -47 53 61 -26 5 1 -92 -28 -8 79 87 35 3 -84 19 74 -99 -28 -87 -83 46 -34 40 -65 -64 0 29 -87 -25 -84 -54 -20 69 59 6 -26 -40 14 -2 52 -7 -15 -61 49 -47 58 -25 -46 82 -60 -29 28 7 64 64 43 -36 -55 8 -9 -39 7 23 82 -34 -70 -91 -21 -4 7 83 42 93 -77 -9 98 33 66 -47 -32 -93 24 96 -34 -60 12 61 5 10 -31 48 23 28 -28 6 95 -46 -33 -74 2 74 -91 -56 19 84 35 18 -30 -46 23 38 -87 -53 -14 -21 -60 51 92 -3 -39 -39 -55 36 90 -31 -58 37 23 -39 15 -74 -64 24 -78 7 -39 10 -75 -17 64 48 -79 29 48 -41 -92 88 -90 -100 -15 -77 -87 -18 60 55 52 54 -56 -73 -84 59 -95 -96 -64 -72 11 -51 38 -11 32 -46 89 53 83 37 -88 43 -23 75 -5 14 98 8 49 10 -84 1 -35 -88 28 -67 72 34 -63 60 14 0 -91 -48 89 41 6 79 -54 -11 -32 -90 -68 -2 85 27 -88 36 87 61 -54 55 -86 -37 68 -5 -52 -8 81 -15 -48 -5 38 -87 47 27 54 -95 6 -100 -6 27 62 -22 -75 48 57 89 -16 -4 3 -18 -48 17 -2 72 -88 46 -36 45 84 -32 -60 22 -19 87 -99 87 44 -40 39 -62 87 1 -32 -88 -99 77 53 -15 -26 -44 20 -22 26 70 -50 -10 16 -34 -64 -48 -14 -24 74 67 -84 76 6 60 -64 -55 51 75 -2 -81 39 0 97 -8 37 -77 1 -43 1 -73 -73 3 17 -4 69 53 48 -45 82 -25 74 98 -49 -20 10 -61 -23 -39 -86 75 -67 53 -25 82 97 -87 57 -2 -78 -42 25 -98 13 95 -2 -66 0 98 -59 -18 -27 67 -68 24 -53 43 15 -24 56 29 -97 41 -66 -69 23 -68 -56 -20 30 -82 -10 -92 -80 -97 -97 -30 89 3 -31 -70 38 42 97 70 -81 96 -35 34 -76 -78 -84 -72 63 -50 -41
