package igorkorapin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ValuesList {

    public static void writeFile(Val valList) {
        try (PrintWriter out =  new PrintWriter("w_values.scv")) {
            for (String v : valList.getHeader()) {
                out.print(v + ";");
            }
            out.println();

            int[][] valListData = valList.getData();
            for (int i = 0; i < valListData.length; i++) {
                for (int j = 0; j < valListData[i].length; j++) {
                    out.print(valListData[i][j] + ";");
                }
                out.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Val readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("values.csv"));
        List<int[]> dataArr = new ArrayList<>();
        String[] dataHeader = in.readLine().split(";");
        String readLine = null;
        while ((readLine = in.readLine()) != null) {
            List<Integer> lineArr = new ArrayList<>();
            String[] tokens = readLine.split(";");
            for (int i = 0; i < tokens.length; i++) {
                lineArr.add(Integer.parseInt(tokens[i]));
            }
            dataArr.add(lineArr.stream().mapToInt(i -> i).toArray());
        }
        Val valList2 = new Val(dataHeader,dataArr.toArray(new int[0][]));
        int[][] tt = valList2.getData();
        return valList2;
    }

    public static void main(String[] args) throws IOException {
        String[] header = {"Val1", "Val2", "Val3"};
        int[][] data = {{500, 700, 300}, {700, 100, 100}, {800, 100, 200}, {111, 1111, 111}};
        Val valList = new Val(header, data);
        writeFile(valList);

        try {
            Val readedCsv = readFile();
            for (String v : readedCsv.getHeader()) {
                System.out.print(v + ";");
            }
            System.out.println();
            int[][] readedCsvDate = readedCsv.getData();
            for (int i = 0; i < readedCsvDate.length; i++) {
                for (int j = 0; j < readedCsvDate[i].length; i++) {
                    System.out.print(readedCsvDate[i][j] + ";");
                }
                System.out.print("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
