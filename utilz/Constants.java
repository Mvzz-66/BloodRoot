package utilz;

public class Costants {

    public static class PlayerCostans {
        public static final int RUN_R = 0;
        public static final int RUN_L = 1;
        public static final int IDLE = 2;
        public static final int HIT = 3;
        public static final int JUMP = 4;
        public static final int ATTACK_1 = 5;
        public static final int FALLING = 6;

    }
    public static int GetSpriteAmount(int player_action) {
        switch (player_action) {
            case RUN_R:
            case IDLE:
                return 12;
            case HIT:
                return 1;
            case JUMP:
                return 5;
            case ATTACK_1:
                return 4;
            case FALL:
                return 5;
            default:
                return 1;
        }
    }
}