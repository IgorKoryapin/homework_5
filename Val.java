package igorkorapin;

public class Val {
    private String[] header;
    private int[][] data;

    public Val(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }
}
