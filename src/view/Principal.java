package view;
 
import controller.ThreadJoKenPo;
 
public class Principal {
    public static int ttA;
    public static int ttB;
 
    public static void main(String[] args) {
        String nomesA[] = {"Mariana", "Ricardo", "Giovana", "Isabella", "Samuel"};
        String nomesB[] = {"Ricardo", "Lucas", "Henrique", "Felipe Prior", "Babu"};
 
        Thread t1 = new ThreadJoKenPo(nomesA[0], nomesB[0]);
        Thread t2 = new ThreadJoKenPo(nomesA[1], nomesB[1]);
        Thread t3 = new ThreadJoKenPo(nomesA[2], nomesB[2]);
        Thread t4 = new ThreadJoKenPo(nomesA[3], nomesB[3]);
        Thread t5 = new ThreadJoKenPo(nomesA[4], nomesB[4]);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
       
        // Verifica se a thread ainda esta "viva" para que não rode outra
        while((t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || t5.isAlive())) {
        }
       
        if(ttA>ttB) {
            System.out.println("O time A venceu com "+ttA+" pontos");
        			}
        else {
            System.out.println("O time B venceu com "+ttB+" pontos");
        	 }
    }
 
}