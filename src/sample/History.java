package sample;
public class History{
    private float diem;
    private int vong;
    public History(){

    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public int getVong() {
        return vong;
    }

    public void setVong(int vong) {
        this.vong = vong;
    }

    public History(int vong, float diem){
        this.diem = diem;
        this.vong = vong;
    }
}