import java.util.Arrays;

public class MyCollection {
    String[] arrayStr;
    int count;

    public MyCollection(int countStr) {
        this.arrayStr = new String[countStr];
        this.count = 0;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "arrayStr=" + Arrays.toString(arrayStr) +
                ", count=" + count +
                '}';
    }
}
