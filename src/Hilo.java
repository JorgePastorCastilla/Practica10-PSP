import java.io.BufferedReader;
import java.io.FileReader;

public class Hilo extends Thread {

    private char vocal;
    private char vocalMayuscula;
    private int cuentaVocales;
    private int cuentaVocal;

    public Hilo(char vocal, char vocalMayuscula){
        this.vocal = vocal;
        this.vocalMayuscula = vocalMayuscula;
    }

    public void leerArchivo(){

        try(BufferedReader br = new BufferedReader( new FileReader(rutaEntrada) ) ) {
            int p;
            char vocal;
            while ( (p = br.read()) != -1) {
                vocal = (char) p;
                if (vocal == 'a'){
                    sumar++;
                }
            }
        }catch (Exception e){

        }

    }

    @Override
    public void run() {
        super.run();

        
    }
}
