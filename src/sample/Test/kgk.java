package sample.Test;

import java.io.IOException;

public class kgk {
    public static void main(String[] args) throws IOException {
        Exercise test=new Exercise("src/sample/Test/data.txt");
        String str=test.getData();
        str = str.replaceAll("\\W+"," ");
        String arr[]=str.split(" ");
        for(String a: arr){
            System.out.println(a);
        }
    }
}
