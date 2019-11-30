import java.io.*;

public class Hilo extends Thread {

    private char vocal;
    private char vocalMayuscula;
    public static int cuentaVocales = 0;
    private int cuentaVocal = 0;
    String rutaEntrada = "src/Entrada.txt";
    String rutaSalida = "src/Vocals.txt";

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
                if (vocal == this.vocal || vocal == this.vocalMayuscula){
                    cuentaVocal++;
                    sumarVocales();
                }
            }
            try( BufferedWriter bw = new BufferedWriter( new FileWriter( rutaSalida, true ) ) ) {
                bw.write(this.vocal + " x " + cuentaVocal + " -> Total = " + cuentaVocales);
                bw.newLine();
                //escribirTotal();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }catch (Exception e){

        }
    }
    public synchronized void sumarVocales(){
        cuentaVocales++;
    }


    private synchronized void escribirTotal() {
        try( BufferedWriter bw = new BufferedWriter( new FileWriter( rutaSalida ) ) ) {
            bw.write(cuentaVocales);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();

        leerArchivo();
    }
}
