package ini.punya.rustandy.model;

import java.io.Serializable;

/**
 * Created by Rustandy Muslim on 10-01-2024
 * Github : https://github.com/rustandimuslim
 * Instagram : https://www.instagram.com/rstndy_00
 */

public class ModelDaftarPenyakit implements Serializable {

    String strKode;
    String strDaftarPenyakit;

    public String getStrKode() {
        return strKode;
    }

    public void setStrKode(String strKode) {
        this.strKode = strKode;
    }

    public String getStrDaftarPenyakit() {
        return strDaftarPenyakit;
    }

    public void setStrDaftarPenyakit(String strDaftarPenyakit) {
        this.strDaftarPenyakit = strDaftarPenyakit;
    }

}
