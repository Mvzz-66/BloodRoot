package main;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePannel gamePannel;
    private Thread gameThread;
    private final int FPS_LIMIT = 120; // limitatore fps è a 60

    public Game() {
        gamePannel = new GamePannel();
        gameWindow = new GameWindow(gamePannel);
        gamePannel.requestFocus();
        gameLoop();
    }

    public void gameLoop(){ //game loop serve per aggiornare continuamente il gioco, senza mai fermarsi
        gameThread = new Thread(this);
        gameThread.start();
    }

    // gestione dei FPS nel game loop
    @Override
    public void run() {
        double tempoPerFrame = 1000000000.0 / FPS_LIMIT; //nano secondi
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frame = 0;
        long lastContrallo = System.currentTimeMillis();

        while (true){

            now = System.nanoTime();

            if(now - lastFrame >= tempoPerFrame){ // controlla se é passato abbastanza tempo per il prossimo frame
                gamePannel.update();    //aggiorna la logia
                gamePannel.repaint(); //ridisegna
                lastFrame = now;    //resetta timer
                frame++;
            }

            //Contatore FPS
            if(System.currentTimeMillis() - lastContrallo >= 1000){
                lastContrallo = System.currentTimeMillis();
                System.out.println("FPS: " + frame);
                frame = 0;
            }
        }
    }
}