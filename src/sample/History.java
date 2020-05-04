package sample;
public class History{
    private double diem;
    private int vong;
    public History(){

    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public int getVong() {
        return vong;
    }

    public void setVong(int vong) {
        this.vong = vong;
    }

    public History(int vong, double diem){
        this.diem = diem;
        this.vong = vong;
    }
}