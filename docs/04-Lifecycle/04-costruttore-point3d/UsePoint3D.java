// Classe contenitore aggiunta per rendere autonomo l'esempio delle slide 18-19.
class UsePoint3D {
    public static void main(String[] args) {
        // creo l'oggetto usando il costruttore a tre argomenti
        Point3D p = new Point3D(10.0, 20.0, 30.0);

        // stampo
        System.out.println("p: " + p.x + "," + p.y + "," + p.z);

        // Il costruttore di default in questo caso non funziona:
        // Point3D p2 = new Point3D(); // NO!
    }
}
