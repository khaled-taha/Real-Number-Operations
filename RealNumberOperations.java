import java.math.BigDecimal;
import java.math.BigInteger;

public class RealNumberOperations {

    private long val;
    private int bdp;
    private BigDecimal number;

    public RealNumberOperations(long val, int bdp) {
        this.val = val;
        this.bdp = bdp;
        this.number = this.generateDecimalNumber(val, bdp);
    }

    public RealNumberOperations(double number) {
        this.val = this.AnalyseVal(number);
        this.bdp = this.AnalyseNdp(number);
        this.number = new BigDecimal(number);
    }

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }

    public int getBdp() {
        return bdp;
    }

    public void setBdp(int bdp) {
        this.bdp = bdp;
    }

    public RealNumberOperations add(RealNumberOperations number) {
        this.number = this.number.add(number.number);
        double n = number.number.doubleValue();
        this.val = this.AnalyseVal(n);
        this.bdp = this.AnalyseNdp(n);
        return this;
    }

    public RealNumberOperations addInteger(long number) {
        return this.add(new RealNumberOperations(number));
    }

    public RealNumberOperations mul(RealNumberOperations number) {
        this.number = this.number.multiply(number.number);
        double n = number.number.doubleValue();
        this.val = this.AnalyseVal(n);
        this.bdp = this.AnalyseNdp(n);
        return this;
    }

    public RealNumberOperations mulInteger(long number) {
        return this.mul(new RealNumberOperations(number));
    }

    public long round(RealNumberOperations number) {
        double n = number.number.doubleValue();
        return Math.round(n);
    }

    public double show() {
        return this.number.doubleValue();
    }

    private long AnalyseVal(double number) {
        String num = new BigDecimal(String.valueOf(number)).toString().replaceFirst("[.]", "");
        return Long.parseLong(num);
    }

    private int AnalyseNdp(double number) {
        String num = new BigDecimal(String.valueOf(number)).toString().replaceFirst("[0-9]+[.]", "");
        return num.length();
    }

    private BigDecimal generateDecimalNumber(long val, int ndp) {
        BigInteger d = new BigInteger(String.valueOf(val));
        return new BigDecimal(d, ndp);
    }
    

}
