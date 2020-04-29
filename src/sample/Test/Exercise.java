package sample.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise {
    private String fileAudio;
    private String fileAnswer;

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
            temp+=st+" ";
        }
        return temp;
    }
}
