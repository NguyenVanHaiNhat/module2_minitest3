public class NhanVienParttime extends NhanVien{
    private int workTime;

    public NhanVienParttime(String id, String name, String email, byte age, String phone, int workTime) {
        super(id, name, email, age, phone);
        this.workTime = workTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public double payRoll() {
        return getWorkTime() * 100000;
    }
}
