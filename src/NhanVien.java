public class NhanVien {
    private String id, name, email;
    private byte age;
    private String phone;

    public NhanVien(String id, String name, String email, byte age, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double payRoll() {
        return 0;
    }

}
