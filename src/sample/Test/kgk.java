package sample.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class kgk {
    public static void main(String[] args) throws IOException {
//        Exercise test=new Exercise("src/sample/Test/data.txt");
//        String str=test.getData();
//        String arr[]=str.split(" ");
//        String[] removedNull = Arrays.stream(arr)
//                .filter(value ->
//                        value != null && value.length() > 0
//                )
//                .toArray(size -> new String[size]);
//
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(removedNull));

//        String a="dao             minh              khanh";
//
//        Object s[][]=new Object[2][2];
//        s[0][0]=new String("dkm    kdkdk");
//        s[0][1]=8;
//        int k= Integer.parseInt((String)s[0][1]);
//        System.out.println(k);
//        System.out.println(Arrays.stream(a.split(" ")).
//                filter(values->values!=null&&values.length()>0).toArray(size->new String[size]).length);
        Exercise newE=new Exercise("src/sample/Test/data.txt");
        String a=newE.getData();
        System.out.println(Arrays.toString(newE.getGuide()));
        System.out.println(Arrays.toString(newE.getIndexFirstForEachLine()));
        System.out.println(a);
    }
}
