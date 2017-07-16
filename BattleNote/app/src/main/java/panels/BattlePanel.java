package panels;

import Utils.Animation;
import Utils.Global;
import Utils.Helper;
import android.graphics.Canvas;
import com.example.phandrana.battlenote.R;
import components.Container;
import components.Entity;


/**
 * Created by phandrana on 09/07/2017.
 */
public class BattlePanel extends Container
{
   Entity FHeroEntity;
   Entity FEnnemyEntity;

   public BattlePanel(int parX, int parY, int parWidth, int parHeight)
   {
      super(parX, parY, parWidth, parHeight);

      int playerX = parWidth / 20;
      int playerY = parHeight / 5;

      FHeroEntity = new Entity(playerX, playerY);
      Animation idlingAnimation = new Animation(Helper.ExtractBitmap(R.drawable.playeridling), 1, 100, 100, Global.HORIZONTAL);
      idlingAnimation.ResizeHeight(parHeight / 2);

      Animation attackAnimation = new Animation(Helper.ExtractBitmap(R.drawable.playerattack), 4, 100, 100, Global.HORIZONTAL);
      attackAnimation.ResizeHeight(parHeight / 2);

      attackAnimation.SetNextAnimation(idlingAnimation);

      FHeroEntity.AddAnimation(idlingAnimation);
      FHeroEntity.AddAnimation(attackAnimation);

      addComponent(FHeroEntity);
   }

   public void SetPlayerIdling()
   {
      FHeroEntity.StartAnimation(0); //ENUM!!
   }

   public void SetPlayerAttack()
   {
      FHeroEntity.StartAnimation(1);
   }

   public boolean IsAnimationFinished()
   {
      return true;
   }
}
