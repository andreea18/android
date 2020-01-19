package eu.ase.ro.concedii_sub6_2018;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class HomeExchange implements Parcelable {
    private String adresa;
    private int numarCamere;
    private int suprafata;
    private Date perioada;
    private String tipLocuinta;

    public HomeExchange(String adresa, int numarCamere, int suprafata, Date perioada, String tipLocuinta) {
        this.adresa = adresa;
        this.numarCamere = numarCamere;
        this.suprafata = suprafata;
        this.perioada = perioada;
        this.tipLocuinta = tipLocuinta;
    }

    protected HomeExchange(Parcel in) {
        adresa = in.readString();
        numarCamere = in.readInt();
        suprafata = in.readInt();
        tipLocuinta = in.readString();
        perioada = new Date(in.readLong());
    }

    public static final Creator<HomeExchange> CREATOR = new Creator<HomeExchange>() {
        @Override
        public HomeExchange createFromParcel(Parcel in) {
            return new HomeExchange(in);
        }

        @Override
        public HomeExchange[] newArray(int size) {
            return new HomeExchange[size];
        }
    };

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getNumarCamere() {
        return numarCamere;
    }

    public void setNumarCamere(int numarCamere) {
        this.numarCamere = numarCamere;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(int suprafata) {
        this.suprafata = suprafata;
    }

    public Date getPerioada() {
        return perioada;
    }

    public void setPerioada(Date perioada) {
        this.perioada = perioada;
    }

    public String getTipLocuinta() {
        return tipLocuinta;
    }

    public void setTipLocuinta(String tipLocuinta) {
        this.tipLocuinta = tipLocuinta;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(adresa);
        parcel.writeInt(numarCamere);
        parcel.writeInt(suprafata);
        parcel.writeString(tipLocuinta);
        parcel.writeLong(this.getPerioada().getTime());
    }
}
