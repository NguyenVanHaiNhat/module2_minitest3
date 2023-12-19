public class NhanVienFulltime extends NhanVien{

    private double bonus, fine, wage;

    public NhanVienFulltime(String id, String name, String email, String phone, byte age , double bonus, double fine, double wage) {
        super(id, name, email, age, phone);
        this.bonus = bonus;
        this.fine = fine;
        this.wage = wage;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double payRoll() {
        return getWage() + (getBonus() - getFine());
    }
}
