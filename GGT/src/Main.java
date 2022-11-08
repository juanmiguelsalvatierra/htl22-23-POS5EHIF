public class Main {
    public static void main(String[] args) {
        /*System.out.println(ggt(15,20));
        System.out.println(ggt(24, 16));
        System.out.println(ggt(25,16));*/
        System.out.println(potenz_mod_n(2,0,5));
        System.out.println(potenz_mod_n(2,1,5));
        System.out.println(potenz_mod_n(2,2,5));
        System.out.println(potenz_mod_n(3,128,5));
        System.out.println(potenz_mod_n(2,128,5));
        System.out.println(potenz_mod_n(3,3,5));
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
}