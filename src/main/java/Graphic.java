import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Random;

public class Graphic {
    static Random random = new SecureRandom();
    static double m;
    static double n = 9999999;
    // 默认除法运算精度
    private static final Integer DEF_DIV_SCALE = 50;

    public static void play() {
        for (int i = 0; i < n; i++) {
            throwNeedle();
        }
        double pi = divide(n, m, DEF_DIV_SCALE);
        System.out.println("圆周率PI：" + pi);
    }

    public static void throwNeedle() {
        Needle needle = generateNeedle();
        if (needle.crossLine) {
            m++;
        }
    }

    private static Needle generateNeedle() {
        double y1 = random.nextDouble() - 0.5;
        double angle = 180 * random.nextDouble();
        double y2 = y1 + Math.sin(angle) * 0.5;
        boolean crossLine = false;
        //判断针与横线是否相交
        if ((y1 < 0.0 && y2 > 0) || (y1 > 0 && y2 < 0)) {
            crossLine = true;
        }
        return new Needle(y1, y2, crossLine);
    }

    private static Double divide(Double dividend, Double divisor, Integer scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(dividend));
        BigDecimal b2 = new BigDecimal(Double.toString(divisor));
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        play();
    }
}
