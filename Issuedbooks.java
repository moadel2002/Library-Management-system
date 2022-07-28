public class Issuedbooks {
    private String bookid,procedure,stdId;
    private boolean returned;


    public Issuedbooks(String bookid, String procedure, String stdId, boolean returned) {
        this.bookid = bookid;
        this.procedure = procedure;
        this.stdId = stdId;
        this.returned = returned;
    }


    public String getBookid() {
        return this.bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getProcedure() {
        return this.procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getStdId() {
        return this.stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public boolean isReturned() {
        return this.returned;
    }

    public boolean getReturned() {
        return this.returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }


}
