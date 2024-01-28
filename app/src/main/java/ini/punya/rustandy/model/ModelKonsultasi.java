package ini.punya.rustandy.model;

import java.io.Serializable;

/**
 * Created by Rustandy Muslim on 10-01-2024
 * Github : https://github.com/rustandimuslim
 * Instagram : https://www.instagram.com/rstndy_00
 */

public class ModelKonsultasi implements Serializable {

    String strGejala = null;
    String kodeGejala = null;
    boolean selected = false;

    public String getKodeGejala() {
        return kodeGejala;
    }

    public void setKodeGejala(String kodeGejala) {
        this.kodeGejala = kodeGejala;
    }
    public String getStrGejala() {
        return strGejala;
    }

    public void setStrGejala(String strGejala) {
        this.strGejala = strGejala;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setEnabled(boolean b) {
    }

    public boolean isEnabled() {
        return true;
    }
}
