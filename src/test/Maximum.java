public class Maximum {
    // Méthode générique pour calculer le maximum entre deux valeurs de n'importe quel type comparable

    static class instance <T extends Comparable<T> >{
        public T maxi(T x,T y){
            return (x.compareTo(y) >0) ? x:y;
        }
        public T mini(T x,T y){
            return (x.compareTo(y) >0) ? y:x;
        }
    }

    public static void main(String[] args) {
        // Exemples d'utilisation avec différents types de données
        instance<Integer> integerMaximum = new instance<>();
        System.out.println("maxi entre 3 et 7 (entiers) : " + integerMaximum.maxi(3, 7));

        instance<Double> doubleMaximum = new instance<>();
        System.out.println("mini entre 4.5 et 2.3 (doubles) : " + doubleMaximum.mini(4.5, 2.3));

        instance<String> stringMaximum = new instance<>();
        System.out.println("Maximum entre 'hello' et 'world' (chaines de caractères) : " + stringMaximum.maxi("hello", "world"));
    }
}
