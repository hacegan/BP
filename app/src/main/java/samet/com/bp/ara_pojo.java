package samet.com.bp;

import android.graphics.drawable.Drawable;

/**
 * Created by root on 26.01.2018.
 */

public class ara_pojo {
    String ilanbaslik,ilanaciklama,ilanid;
    Drawable photo;

    public ara_pojo() {
    }

    public ara_pojo(String ilanbaslik, String ilanaciklama, Drawable photo,String ilanid) {
        this.ilanbaslik = ilanbaslik;
        this.ilanaciklama = ilanaciklama;
        this.photo = photo;
        this.ilanid=ilanid;
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

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }


    public String getIlanid() {
        return ilanid;
    }

    public void setIlanid(String ilanid) {
        this.ilanid = ilanid;
    }
}
