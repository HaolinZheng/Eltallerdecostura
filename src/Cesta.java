public class Cesta {
    private int numMax, piezas;
    private boolean manga, max;
    public Cesta(int numMax, boolean manga) {
        this.numMax = numMax;
        this.manga = manga;
        max = false;
    }
    public boolean isManga() {
        return manga;
    }
    public boolean isMax() {
        return max;
    }
    public int getPiezas() {
        return piezas;
    }
    public synchronized void añadirPieza (){
        piezas++;
        if (numMax == piezas) {
            max = true;
        }
        if (manga) System.out.println("Manga " + piezas);
        else System.out.println("Cuerpo " + piezas);
    }
    public synchronized void restarPieza(){
        if (manga) piezas -= 2;
        else piezas--;
        max = false;
    }
}
