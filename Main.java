import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CovidConfig cfg = new CovidConfig("covid_config.json");
        System.out.print("Berapa suhu badan anda saat ini ? dalam nilai "+cfg.getSatuanSuhu()+" : "); double suhu = Double.valueOf(input.nextLine()); 
        System.out.print("Berapa hari yang lalu (perkiraan) anda terakhir memiliki gejala demam ? : "); int hari = Integer.valueOf(input.nextLine());
        boolean gate1 = false;
        boolean gate2 = false;
        if (cfg.getSatuanSuhu() == "celcius") {
            if (suhu <= 37.5 && suhu >= 36.5) {
                gate1 = true;
            }
        }else if (cfg.getSatuanSuhu() == "fahrenheit") {
            if (suhu <= 99.5 && suhu >= 97.7) {
                gate1 = true;
            }
        }
        if (hari < cfg.getBatasDemam()){
            gate2 = true;
        }
        if (gate1 && gate2){
            System.out.println(cfg.getPesanDiterima());
        }else{
            System.out.println(cfg.getPesanDitolak());
        }
        System.out.print("Ganti satuan suhu : ");
        cfg.setSatuanSuhu(input.nextLine());
        cfg.WriteJson("covid_config.json");
    }   
}
