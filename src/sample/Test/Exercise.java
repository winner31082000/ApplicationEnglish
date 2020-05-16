package sample.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Exercise {
    private String fileAudio;
    private String fileAnswer;
    private int line=0;
    private String[] guide=new String[2];
    public int getLine() {
        return line;
    }

    public int[] getIndexFirstForEachLine() {
        return indexFirstForEachLine;
    }

    public void setIndexFirstForEachLine(int[] indexFirstForEachLine) {
        this.indexFirstForEachLine = indexFirstForEachLine;
    }

    private int indexFirstForEachLine[]=new int[25];
    public String[] getGuide() {
        return guide;
    }

    public void setGuide(String[] guide) {
        this.guide = guide;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public Exercise(String fileAnswer){
        this.fileAnswer=fileAnswer;
    }

    public String getFileAudio() {
        return fileAudio;
    }

    public void setFileAudio(String fileAudio) {
        this.fileAudio = fileAudio;
    }

    public String getFileAnswer() {
        return fileAnswer;
    }

    public void setFileAnswer(String fileAnswer) {
        this.fileAnswer = fileAnswer;
    }

    public String getData() throws IOException {
        String temp="",temp1="";
        String st;
        BufferedReader reader=new BufferedReader(new FileReader(fileAnswer));
        while ((st=reader.readLine())!=null){
            if(line<2){
                guide[line]=st;
                line++;
                continue;
            }
            temp+=st+" ";
            if(line==2){
                indexFirstForEachLine[0]= Arrays.stream(st.split(" ")).
                        filter(values->values!=null&&values.length()!=0).toArray().length;
            }
            else{
                indexFirstForEachLine[line-2]=indexFirstForEachLine[line-3]+
                        Arrays.stream(st.split(" ")).
                                filter(values->values!=null&&values.length()!=0).toArray().length;
            }
            line++;
        }
        if(line<4){
            temp1=guide[1]+" "+temp;
            int j=line-2;
            int a=Arrays.stream(guide[1].split(" ")).filter(vales->vales.length()!=0).toArray().length;
            while (j>=1){
                indexFirstForEachLine[j]=indexFirstForEachLine[j-1]+a;

                j--;
            }
            indexFirstForEachLine[0]=a;
            guide[1]="";
            return temp1;
        }
        return temp;
    }
}
