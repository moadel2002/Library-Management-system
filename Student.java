
public class Student {
    private String name,id,birth,mail,phone;

    public Student(String name, String id, String birth, String mail, String phone) {
        this.name = name;
        this.id = id;
        this.birth = birth;
        this.mail = mail;
        this.phone = phone;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    
}