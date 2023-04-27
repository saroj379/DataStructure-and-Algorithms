import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    static boolean isPossibleShipPackge(int[] A, int B, long capPack){
        int numberOfDays = 1;
        long packagesToShip = 0;
        for(int e : A){
            if(packagesToShip+e <= capPack){
                packagesToShip += e;
            }else{
                numberOfDays++;
                packagesToShip = e;
            }
        }
        return numberOfDays <= B;
    }

    public static long solve(int[] A, int B) {
        long min = 0, max = 0;
        for(int e: A){
            min = Math.max(min, e);// the max i need
            max += e; // if in 1 day it will take all those bages
        }

        long lo = min;
        long hi = max;
        long pAns = 0;
        while(lo <= hi){
            long capPack = (lo + hi) / 2;
            if(isPossibleShipPackge(A, B, capPack)){
                pAns = capPack;
                hi = capPack -1;
            }
            else lo = capPack +1;
        }

        return pAns;
    }
}

class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A,B));
    }
}