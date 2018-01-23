package samet.com.bp;

/**
 * Created by root on 19.01.2018.
 */

public class kirala_pojo {
    String ilanbaslik,ilanaciklama;
    int photo;

    public kirala_pojo(String ilanbaslik, String ilanaciklama, int photo) {
        this.ilanbaslik = ilanbaslik;
        this.ilanaciklama = ilanaciklama;
        this.photo = photo;
    }


    public String getIlanbaslik() {
        return ilanbaslik;
    }

    public void setIlanbaslik(String ilanbaslik) {
        this.ilanbaslik = ilanbaslik;
    }

    public String getIlanaciklama() {
        return ilanaciklama;
    }

    public void setIlanaciklama(String ilanaciklama) {
        this.ilanaciklama = ilanaciklama;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
