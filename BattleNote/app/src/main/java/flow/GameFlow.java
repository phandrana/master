package flow;

import Utils.Delay;
import Utils.Global;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import panels.BattlePanel;
import panels.InputNotePanel;
import panels.MusicSheetPanel;

/**
 * Created by phandrana on 09/07/2017.
 */
public class GameFlow extends SurfaceView implements SurfaceHolder.Callback
{
   public int FGameState;
   public int FInputState;

   MainThread FThread;

   //à déplacer --------
   Delay FDelayFeedback;
   int FColorScreen;
   // ------------------

   InputNotePanel FInputNotePanel;
   MusicSheetPanel FMusicSheetPanel;
   BattlePanel FBattlePanel;

   public GameFlow(Context context)
   {
      super(context);

      getHolder().addCallback(this);

      FThread = new MainThread(getHolder(), this);

      setFocusable(true);
   }

   @Override
   public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
   {
   }

   @Override
   public void surfaceDestroyed(SurfaceHolder holder)
   {
      while(true)
      {
         try
         {
            FThread.setRunning(false);
            FThread.join();
         }
         catch(InterruptedException e)
         {
            e.printStackTrace();
         }

         break;
      }
   }

   @Override
   public void surfaceCreated(SurfaceHolder holder)
   {

      //----------------------------------------------------------------------------------------------------------------
      int musicSheetWidth = getWidth();
      int musicSheetPanelHeight = getHeight() / 7;

      FMusicSheetPanel = new MusicSheetPanel(0, 0, musicSheetWidth, musicSheetPanelHeight);
      //----------------------------------------------------------------------------------------------------------------
      int inputNotePanelWidth = getWidth();
      int inputNotePanelHeight = getHeight() / 3;

      FInputNotePanel = new InputNotePanel(0, (getHeight() - inputNotePanelHeight), inputNotePanelWidth, inputNotePanelHeight);
      // ---------------------------------------------------------------------------------------------------------------
      int battlePanelWidth = getWidth();
      int battlePanelHeight = getHeight() - inputNotePanelHeight - musicSheetPanelHeight;

      FBattlePanel = new BattlePanel(0, musicSheetPanelHeight, battlePanelWidth, battlePanelHeight);

      // ---------------------------------------------------------------------------------------------------------------
      FBattlePanel.SetPlayerIdling();

      FDelayFeedback = new Delay(200);
      FColorScreen = Color.WHITE;


      FGameState = Global.PLAYER_TURN;

      FThread.setRunning(true);
      FThread.start();
   }

   @Override
   public boolean onTouchEvent(MotionEvent event)
   {
      switch(FGameState)
      {
         case Global.PLAYER_TURN:
         {
            int signal = FInputNotePanel.GetSignal((int) event.getX(), (int) event.getY());

            if(signal != 0)
            {

               if(FMusicSheetPanel.SendSignal(signal))
               {
                  FInputState = Global.INPUT_SUCCEED;
                  FColorScreen = Color.GREEN;
                  FBattlePanel.SetPlayerAttack();
               }
               else
               {
                  FInputState = Global.INPUT_FAILED;
                  FColorScreen = Color.RED;
               }

               FDelayFeedback.Start();
            }
         }
         break;

         case Global.ENNEMY_TURN:
            break;

         default:
            break;

      }

      return super.onTouchEvent(event);
   }

   public void Update(Canvas parCanvas)
   {
      if(FDelayFeedback.IsFinished())
      {
         FMusicSheetPanel.RandomizeNote();
         FColorScreen = Color.WHITE;
         FInputNotePanel.SetDisplayButtons(false);
      }

      switch(FGameState)
      {
         case Global.PLAYER_ATTACK_ANIMATION:
            if(FBattlePanel.IsAnimationFinished())
            {
               FGameState = Global.PLAYER_TURN; //TMP quand y aura le rythme ce sera au tour de l'ennemi
            }
            break;

         case Global.ENNEMY_ATTACK_ANIMATION:
            //TO DO
            break;

         default:
            break;

      }

      if(parCanvas == null)
         return;

      Paint p = new Paint();
      //
      p.setColor(FColorScreen);
      parCanvas.drawRect(0, 0, getWidth(), getHeight(), p);
      //

      FMusicSheetPanel.Draw(parCanvas);
      FInputNotePanel.Draw(parCanvas);
      FBattlePanel.Draw(parCanvas);
   }
}
