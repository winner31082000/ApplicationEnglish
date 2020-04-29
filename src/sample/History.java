package sample;
public class History{
    private int diem;
    private int vong;
    public History(){

    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getVong() {
        return vong;
    }

    public void setVong(int vong) {
        this.vong = vong;
    }

    public History(int vong, int diem){
        this.diem = diem;
        this.vong = vong;
    }
}