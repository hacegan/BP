package samet.com.bp;

import io.realm.RealmObject;

/**
 * Created by root on 19.01.2018.
 */

public class kirala_pojo  {
    String ilanbaslik,ilanaciklama,ilanid;
    int photo;

    public kirala_pojo() {
    }

    public kirala_pojo(String ilanbaslik, String ilanaciklama, int photo,String ilanid) {
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

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }


    public String getIlanid() {
        return ilanid;
    }

    public void setIlanid(String ilanid) {
        this.ilanid = ilanid;
    }
}
