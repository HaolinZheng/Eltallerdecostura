public class Main {
    public static void main(String[] args) {
        Cesta c1 = new Cesta(10,true);
        Cesta c2 = new Cesta(10,false);

        Costurero t1 = new Costurero("Chinchong1",c1);
        Costurero t2 = new Costurero("Chinchong2",c2);
        Costurero t3 = new Costurero("Chinchong3",c1,c2);

        t1.start();
        t2.start();
        t3.start();
    }
}