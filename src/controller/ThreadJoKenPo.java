package controller;
import java.util.concurrent.Semaphore;
import view.Principal;

public class ThreadJoKenPo extends Thread {
    private int pontos1 = 0;
    private int pontos2 = 0;
   
    private String jogA;
    private String jogB;
 
    // Alerta amarelo dont know why
    private Semaphore FreshPrince = new Semaphore(1);
   
    public ThreadJoKenPo(String jogadorA, String jogadorB) {
        this.jogA = jogadorA;
        this.jogB = jogadorB;
    }
   
    public void run() {
        Jogo();
    }
 
    //Metodos pro 
    private void Jogo() {
        // se ganhador = 1
        // jogador A ganhou
 
        // se ganhador = 2
        // jogador B ganhou
 
        // se ganhador = 0
        // empate
        while(pontos1 < 3 && pontos2 < 3) 
        {
            int win = 0;
            try
            	{
                sleep(1000);
                win = verJogada();
            	} 
            catch (InterruptedException e) 
            	{
                e.printStackTrace();
            	}
           
            if(win == 1) pontos1++;
            if(win == 2) pontos2++;
        }
       
        if(pontos1 > pontos2) 
        {
            System.out.println(jogA+" fez "+pontos1+" pontos, time A ganhou essa rodada");
            Principal.ttA++;
        }
        	else {
            System.out.println(jogB+" fez "+pontos2+" pontos, time B ganhou essa rodada");
            Principal.ttB++;
        		 }
        System.out.println("O time A tem "+Principal.ttA+" pontos");
        System.out.println("O time B tem "+Principal.ttB+" pontos");       
    }
 
    private int verJogada() {
        int jogo1 = 0;
        int jogo2 = 0;
        String jogos[] = { "pedra", "papel", "tesoura" };
 
        // 1 = pedra
        // 2 = papel
        // 3 = tesoura
 
        jogo1 = (int) ((Math.random() * 3) + 1);
        jogo2 = (int) ((Math.random() * 3) + 1);
 
        if (jogo1 == jogo2) {
            System.out.println(jogA + " jogou " + jogos[jogo1-1] + " e " + jogB + " jogou " + jogos[jogo2-1] + "\n");
            System.out.println("O jogo deu empate");
            return 0;
        } else if (jogo1 == 1 && jogo2 == 3) {
            System.out.println(jogA + " jogou " + jogos[jogo1-1] + " e " + jogB + " jogou " + jogos[jogo2-1] + "\n");
            System.out.println("Quem ganhou foi " + jogA);
            return 1;
        } else if (jogo1 == 2 && jogo2 == 1) {
            System.out.println(jogA + " jogou " + jogos[jogo1-1] + " e " + jogB + " jogou " + jogos[jogo2-1] + "\n");
            System.out.println("Quem ganhou foi " + jogA);
            return 1;
        } else if (jogo1 == 3 && jogo2 == 2) {
            System.out.println(jogA + " jogou " + jogos[jogo1-1] + " e " + jogB + " jogou " + jogos[jogo2-1] + "\n");
            System.out.println("Quem ganhou foi " + jogA);
            return 1;
        } else {
            System.out.println(jogA + " jogou " + jogos[jogo1-1] + " e " + jogB + " jogou " + jogos[jogo2-1] + "\n");
            System.out.println("Quem ganhou foi " + jogB);
            return 2;
        }
 
    }
 
}
 