import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------GGT----------------");
        System.out.println(ggt(15,20));
        System.out.println(ggt(24, 16));
        System.out.println(ggt(25,16));
        System.out.println("----------------Potenz_mod_n----------------");
        System.out.println(potenz_mod_n(2,0,5));
        System.out.println(potenz_mod_n(2,1,5));
        System.out.println(potenz_mod_n(2,2,5));
        System.out.println(potenz_mod_n(3,128,5));
        System.out.println(potenz_mod_n(2,128,5));
        System.out.println(potenz_mod_n(3,3,5));
        System.out.println("----------------Primzahl Check----------------");
        System.out.println(isPrim(19));
        System.out.println(isPrim(9973));
        System.out.println(isPrim(65537));
        System.out.println(isPrim(123));
        System.out.println(isPrim(58081));
        System.out.println(isPrim(63001));
        System.out.println(isPrim(65535));
        System.out.println("----------------Schlüssel----------------");
        long m = 1123;
        long c = ver(m, 19, 1271);
        System.out.println("Message: " + m);
        System.out.println("Chiffre: " + ver(m, 19, 1271));
        System.out.println("Entschlüsselt: " + ent(c, 379, 1271));
    }

    public static long ggt(long a, long b){
        if(b > 0){
            return ggt(b, a % b);
        }
        else{
            return a;
        }
    }

    public static long potenz_mod_n(long z, long h, long n){
        long erg = 1;
        for (int i = 0; i < h; i++) {
            erg = erg * z;
            erg = erg % n;
        }
        return erg;
    }

    public static boolean isPrim(long n){
        Random rnd = new Random();
        long a = rnd.nextLong(1, n);
        if(n % 2 == 0){
            return false;
        }
        if(ggt(a,n) > 1){
            return false;
        }
        boolean temp = false;
        for(int i = 0; i < 20; i++) {
            long b = potenz_mod_n(a, (n-1)/2, n);
            if (b == 1 || b == (n-1)) {
                temp = true;
            } else {
                return false;
            }
        }
        return temp;
    }

    public static long ver(long m, long k1, long n){
        long c = potenz_mod_n(m, k1, n);

        return c;
    }

    public static long ent(long c, long k2, long n){
        long m = potenz_mod_n(c, k2, n);

        return m;
    }
}