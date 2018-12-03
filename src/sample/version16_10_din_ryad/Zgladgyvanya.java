package sample.version16_10_din_ryad;

public class Zgladgyvanya {
    private int id;
    private double initialValue;
    private double mnk;
    private double vidhilenyaMNK;
    private double med;
    private double vidhilenyaMED;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public double getMnk() {
        return mnk;
    }

    public void setMnk(double mnk) {
        this.mnk = mnk;
    }

    public double getVidhilenyaMNK() {
        return vidhilenyaMNK;
    }

    public void setVidhilenyaMNK(double vidhilenyaMNK) {
        this.vidhilenyaMNK = vidhilenyaMNK;
    }

    public double getMed() {
        return med;
    }

    public void setMed(double med) {
        this.med = med;
    }

    public double getVidhilenyaMED() {
        return vidhilenyaMED;
    }

    public void setVidhilenyaMED(double vidhilenyaMED) {
        this.vidhilenyaMED = vidhilenyaMED;
    }

    public Zgladgyvanya(int id, double initialValue, double mnk, double vidhilenyaMNK, double med, double vidhilenyaMED) {

        this.id = id;
        this.initialValue = initialValue;
        this.mnk = mnk;
        this.vidhilenyaMNK = vidhilenyaMNK;
        this.med = med;
        this.vidhilenyaMED = vidhilenyaMED;
    }
}
