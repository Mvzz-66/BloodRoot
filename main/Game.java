package main;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePannel gamePannel;
    private Thread gameThread;
    private final int FPS_LIMIT = 60; // limitatore fps è a 60

    public Game() {
        gamePannel = new GamePannel();
        gameWindow = new GameWindow(gamePannel);
        gamePannel.requestFocus();
        gameLoop();
    }

    public void gameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double tempoPerFrame = 1000000000.0 / FPS_LIMIT;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frame = 0;
        long lastContrallo = System.currentTimeMillis();

        while (true){

            now = System.nanoTime();

            if(now - lastFrame >= tempoPerFrame){
                gamePannel.repaint();
                lastFrame = now;
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