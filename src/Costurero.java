public class Costurero extends Thread{
    Cesta cesta;
    Cesta cesta2;
    boolean juntar = false;
    int ropa = 0;
    public Costurero(String nombre, Cesta c) {
        super(nombre);
        this.cesta = c;
    }
    public Costurero(String nombre, Cesta cm, Cesta cp) {
        super(nombre);
        this.cesta = cp;
        this.cesta2 = cm;
        juntar = true;
    }
    public synchronized void crearPieza() throws InterruptedException {
        if (!juntar && !cesta.isMax()) {
            System.out.println(getName()+" Cosiendo");
            Thread.sleep(((long) (Math.random()*5000)+2000));
            cesta.añadirPieza();
        }
        if (cesta2 != null) {
            if (cesta.isManga() && cesta.getPiezas() >= 2 && cesta2.getPiezas() >= 1) {
                System.out.println(getName()+" Juntando");
                Thread.sleep(((long) (Math.random()*5000)+2000));
                cesta.restarPieza();
                cesta2.restarPieza();
                ropa++;
                System.out.println("------------------------");
                System.out.println("Cantidad de ropa " + ropa);
                System.out.println("Mangas " + cesta.getPiezas());
                System.out.println("Cuerpo " + cesta2.getPiezas());
                System.out.println("------------------------");
            }
            else if (!cesta.isManga() && cesta.getPiezas() >= 1 && cesta2.getPiezas() >= 2) {
                System.out.println(getName()+" Juntando");
                Thread.sleep(((long) (Math.random()*5000)+2000));
                cesta.restarPieza();
                cesta2.restarPieza();
                ropa++;
                System.out.println("------------------------");
                System.out.println("Cantidad de ropa " + ropa);
                System.out.println("Mangas " + cesta2.getPiezas());
                System.out.println("Cuerpo " + cesta.getPiezas());
                System.out.println("------------------------");            }
        }
    }
    public void run() {
        for (;;){
             try {
                 crearPieza();
             }
             catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
        }
    }
}
