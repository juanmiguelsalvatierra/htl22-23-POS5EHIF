public class Main {
    public static void main(String[] args) {
        static Random rnd = new Random();
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
        System.out.println("----------------IsPrim----------------");
        System.out.println(isPrim(19));
        System.out.println(isPrim(9973));
        System.out.println(isPrim(65537));
        System.out.println(isPrim(123));
        System.out.println(isPrim(58081));
        System.out.println(isPrim(63001));
        System.out.println(isPrim(65535));
    }

    public static int ggt(int a, int b){
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
        long a = rnd.next(1, n);
        if(n % 2 == 0){
            return false;
        }
        if(ggt(a,n) > 1){
            return false;
        }
        boolean temp = false;
        for(int i = 0; i < 20; i++) {
            long b = potenz_mod_n(a, (n-1)/2, n);
            if (b == 1 || ) {
                temp = true;
            } else {
                temp = false;
            }
        }
    }
}