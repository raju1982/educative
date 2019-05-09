package string.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.FileWriter;
import static string.sorting.QuickSort.*;

public class SortBigFileImpl {

    public static void main(String[] args) {
        BufferedReader objReader = null;
        int maxLines = 5;
        int line = 0;
        int count = 0;
        List<String> data = new ArrayList<>();
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("/Users/rakeshkandpal/rakesh-work/github/educativeio/src/main/java/string/Test.txt"));
            while ((strCurrentLine = objReader.readLine()) != null) {
                if(line < maxLines){
                    data.add(strCurrentLine);
                    line++;
                }
                else{

                    Collections.sort(data);

                    String[] temp = new String[data.size()];
                    // ArrayList to Array Conversion
                    for (int i =0; i < data.size(); i++) {
                        temp[i] = data.get(i);
                    }
                    data.clear();
                    quickSort(temp, 0, temp.length-1);


                    FileWriter fw = new FileWriter("file_"+ count +".txt");
                    for (int i = 0; i < temp.length; i++) {
                        fw.write(temp[i] + "\n");
                    }
                    fw.close();
                }
            }

            //last rows



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
