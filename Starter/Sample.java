public class Sample {

    public static int add(int num) {
        if (num == 1) {
            return 1;
        }

        return add(num - 1) + num;
    }

    public static int calc_Add(Adder adder, int start, int end, int step, int init) {
        int result = init;
        for (int i = start; i <= end; i += step) {
            result = adder.apply(result, i);
        }
        return result;
    }

    public static int calc_Multi(Multiplier multiplier, int start, int end, int step, int init) {
        int result = init;
        for (int i = start; i <= end; i += step) {
            result = multiplier.apply(result, i);
        }
        return result;
    }

    public static int calc(BinaryOP binaryOP, int start, int end, int step, int init) {
        int result = init;
        for (int i = start; i <= end; i += step) {
            result = binaryOP.apply(result, i);
        }
        return result;
    }


    public static int sigma(int start, int end, int step) {
        return calc(new Adder(), start, end, step, 0);
    }

    public static int pi(int start, int end, int step) {
        return calc((i, j) -> i * j, start, end, step, 1);
    }

    public static void main(String[] args) {
        System.out.println(add(10));

        System.out.println(sigma(1, 10, 1));
        System.out.println(pi(1, 10, 1));

    }
}
