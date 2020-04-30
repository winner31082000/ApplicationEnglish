package sample.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise {
    private String fileAudio;
    private String fileAnswer;
    private int line=0;
    private String[] guide=new String[2];
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
                line++;
                temp += st + " ";
            }
            else{
                guide[line] = st;
                line++;
            }
        }
        temp = temp.replaceAll("[\\p{Punct}&&[^']]+", " ");
        return temp;
    }
}
