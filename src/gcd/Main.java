/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Alberto pc
 */
public class Main {
    public static BigInteger mONE = new BigInteger("-1");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a,b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(GCD(a,b));
    }
    
    /**
     * Method used to find greatest common divisor between a and b
     * This method implements Euclides's algorithm
     * @param a first number
     * @param b second number
     * @return gcd of (a,b)
     */
    public static int GCD(int a, int b){
        if (a < 0) {
            return GCD(-a,b);
        }
        if (b < 0) {
            return GCD(a,-b);
        }
        if (a < b) {
            return GCD(b,a);
        }
        if (b==0) {
            return a;
        }
        if (b==1) {
            return 1;
        }
        return GCD(b,a%b);
    }
    
    /**
     * GCD for big values of a and b
     * @param a big integer
     * @param b big integer
     * @return GCD of (a,b)
     */
    public static BigInteger BigGCD(BigInteger a, BigInteger b){
        if (a.compareTo(BigInteger.ZERO)<0) {
            return BigGCD(a.multiply(mONE), b);
        }
        if (b.compareTo(BigInteger.ZERO)<0) {
            return BigGCD(a, b.multiply(mONE));
        }
        if (a.compareTo(b)<0) {
            return BigGCD(b,a);
        }
        if (b.equals(BigInteger.ZERO)) {
            return a;
        }
        if (b.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return BigGCD(b,a.mod(b));
    }
}
