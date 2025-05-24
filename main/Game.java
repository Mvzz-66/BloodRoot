package main;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePannel gamePannel;
    private Thread gameThread;
    private final int FPS_SET = 120;    // limitatore fps è a 120
    private final int UPS_SET = 120;

    public Game() {
        gamePannel = new GamePannel();
        gameWindow = new GameWindow(gamePannel);
        gamePannel.requestFocus();
        gameLoop();
    }

    public void update(){
        gamePannel.update();
    }

    public void gameLoop(){                     //game loop serve per aggiornare continuamente il gioco, senza mai fermarsi
        gameThread = new Thread(this);
        gameThread.start();
    }

    // gestione dei FPS nel game loop
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePannel.repaint( );
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
    }
}