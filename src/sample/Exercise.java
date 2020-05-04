package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exercise {
    private String fileAudio;
    private String fileAnswer;
    private int line=0;
    private String[] guide=new String[2];
    private int sizeForOneLine[]=new int[25];

    public int[] getSizeForOneLine() {
        int []temp=Arrays.stream(sizeForOneLine).filter(num->num!=0).toArray();
        return temp;
    }

    public void setSizeForOneLine(int[] sizeForOneLine) {
        this.sizeForOneLine = sizeForOneLine;
    }

    public int getLine() {
        return line;
    }

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
        String temp="";
        String st;
        BufferedReader reader=new BufferedReader(new FileReader(fileAnswer));
        while ((st=reader.readLine())!=null){
            if(line>1) {
                temp += st + " ";
                int a= Arrays.stream(st.split(" ")).
                        filter(values->values!=null&&values.length()>0).toArray(size->new String[size]).length;
                if(line==2)
                    sizeForOneLine[line-2]=a;
                else{
                    sizeForOneLine[line-2]+=a+sizeForOneLine[line-3];
                }
                line++;
            }
            else{
                guide[line] = st;
                line++;
            }
        }
        //temp = temp.replaceAll("[\\p{Punct}&&[^']]+", " ");
        return temp;
    }
}
