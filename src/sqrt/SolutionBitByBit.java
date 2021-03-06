package sqrt;

public class SolutionBitByBit {

    public long sqrt(long v) {
        long temp = 0, nHat = 0, b = 0x80000000, bshift = 31;
        do {

            temp = (((nHat << 1) + b) << bshift--);
            if (v >= temp) {
                nHat += b;
                v -= temp;
            }
            b >>= 1;
        } while (b > 0);
        return nHat;
    }

    public int sqrt(int v) {
        int temp, nHat = 0, b = 0x8000, bshift = 15;
        do {

            temp = (((nHat << 1) + b) << bshift--);
            if (v >= temp) {
                nHat += b;
                v -= temp;
            }
            b >>= 1;
        } while (b > 0);
        return nHat;
    }

}
