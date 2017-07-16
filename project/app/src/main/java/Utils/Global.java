package Utils;

/**
 * Created by phandrana on 09/07/2017.
 */
public class Global
{
   //GAME STATE
   public final static int PLAYER_TURN = 0;
   public final static int ENNEMY_TURN = 1;
   public final static int PLAYER_ATTACK_ANIMATION = 2;
   public final static int ENNEMY_ATTACK_ANIMATION = 3;

   //INPUT STATE
   public final static int INPUT_SUCCEED = 0;
   public final static int INPUT_FAILED = 1;

   //NOTE VALUE
   public final static int FA = 1;
   public final static int MI = 2;
   public final static int RE = 4;
   public final static int DO = 8;
   public final static int SI = 16;
   public final static int LA = 32;
   public final static int SOL = 64;


   //Pour les animations
   public final static int VERTICAL = 0;
   public final static int HORIZONTAL = 1;

   //Attention, si modifié, il faut modifier le décalage de la position dans MusicSheetPanel
   public final static int NOTE_POSITION_NUMBER = 9;

}
