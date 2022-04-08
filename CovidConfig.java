/**
 * CovidConfig
 */
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class CovidConfig {
    private String CONFIG1 = "celcius";
    private int CONFIG2 = 14;
    private String CONFIG3 = "Anda tidak diperbolehkan masuk ke dalam gedung ini";
    private String CONFIG4 = "Anda dipersilahkan untuk masuk ke dalam gedung ini";
    public CovidConfig(String path){
        try {
            JSONParser jp = new JSONParser();
            Object obj = jp.parse(new FileReader(path));
            JSONObject jso = (JSONObject) obj;
            CONFIG1 = (String)jso.get("satuan_suhu");
            CONFIG2 = (int)jso.get("batas_hari_demam");
            CONFIG3 = (String)jso.get("pesan_ditolak");
            CONFIG4 = (String)jso.get("pesan_diterima");
        } catch (Exception e) {
            WriteJson(path);
        }
    }
    public void WriteJson(String path){
        JSONObject jso = new JSONObject();
        jso.put("satuan_suhu", this.CONFIG1);
        jso.put("batas_hari_demam", this.CONFIG2);
        jso.put("pesan_ditolak", this.CONFIG3);
        jso.put("pesan_diterima", this.CONFIG4);
        try {
            FileWriter file = new FileWriter(path);
            file.write(jso.toString());
            file.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setSatuanSuhu(String sat){
        this.CONFIG1 = sat;
    }
    public void setBatasDemam(int hari){
        this.CONFIG2 = hari;
    }
    public void setPesanDitolak(String msg){
        this.CONFIG3 = msg;
    }
    public void setPesanDiterima(String msg){
        this.CONFIG4 = msg;
    }
    public String getSatuanSuhu(){
        return this.CONFIG1;
    }
    public int getBatasDemam(){
        return this.CONFIG2;
    }
    public String getPesanDitolak(){
        return this.CONFIG3;
    }
    public String getPesanDiterima(){
        return this.CONFIG4;
    }
}