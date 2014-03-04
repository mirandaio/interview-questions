public class BitInteger {
    public static int INTEGER_SIZE = 31;
    private boolean[] bits;

    public BitInteger() {
        bits = new boolean[INTEGER_SIZE];
    }

    public BitInteger(int value) {
        bits = new boolean[INTEGER_SIZE];

        for(int j = 0; j < INTEGER_SIZE; j++) {
            if(((value >> j) & 1) == 1) {
                bits[INTEGER_SIZE - 1 - j] = true;
            } else {
                bits[INTEGER_SIZE - 1 - j] = false;
            }
        }
    }

    /* Returns k-th most-significant bit.
     */
    public int fetch(int k) {
        if(bits[k])
            return 1;

        return 0;
    }

    /* Sets k-th most-significant bit.
     */
    public void set(int k, int bitValue) {
        if(bitValue == 0)
            bits[k] = false;
        else
            bits[k] = true;
    }

    public void swapValues(BitInteger number) {
        for(int i = 0; i < INTEGER_SIZE; i++) {
            int temp = number.fetch(i);
            number.set(i, this.fetch(i));
            this.set(i, temp);
        }
    }

    public int toInt() {
        int n = 0;

        for(int i = 0; i < INTEGER_SIZE; i++) {
            n = n << 1;

            if(bits[i])
                n = n | 1;
        }

        return n;
    }
}
