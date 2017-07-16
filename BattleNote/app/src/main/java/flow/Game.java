package flow;

import android.app.Activity;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

public class Game extends Activity
{
   public static GameFlow SGameFlow;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      //turn title off
      requestWindowFeature(Window.FEATURE_NO_TITLE);

      //set to full screen
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
      SGameFlow = new GameFlow(this);
      setContentView(new GameFlow(this));
   }
}