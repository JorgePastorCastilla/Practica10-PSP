import java.io.*;

public class Hilo extends Thread {

    private char vocal;
    private char vocalMayuscula;
    private static int cuentaVocales = 0;
    private int cuentaVocal = 0;
    String rutaEntrada = "C:\\Users\\Alumne\\IdeaProjects\\PSP\\Practica10\\src\\Entrada.txt";
    String rutaSalida = "C:\\Users\\Alumne\\IdeaProjects\\PSP\\Practica10\\src\\Vocals.txt";

    public Hilo(char vocal, char vocalMayuscula){
        this.vocal = vocal;
        this.vocalMayuscula = vocalMayuscula;
    }

    public synchronized void leerArchivo(){

        try(BufferedReader br = new BufferedReader( new FileReader(rutaEntrada) ) ) {
            int p;
            char vocal;
            while ( (p = br.read()) != -1) {
                vocal = (char) p;
                if (vocal == this.vocal || vocal == this.vocalMayuscula){
                    cuentaVocal++;
                    cuentaVocales++;
                }
            }
            try( BufferedWriter bw = new BufferedWriter( new FileWriter( rutaSalida, true ) ) ) {
                bw.write(this.vocal + " x " + cuentaVocal);
                bw.newLine();
                //escribirTotal();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }catch (Exception e){

        }

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
