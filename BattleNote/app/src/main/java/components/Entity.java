package components;

import Utils.Animation;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by phandrana on 08/07/2017.
 */
public class Entity extends Component
{
   ArrayList<Animation> FAnimations;
   int FCurrentAnimation;

   public Entity(int parX, int parY)
   {
      super(parX, parY);

      FCurrentAnimation = 0;
      FAnimations = new ArrayList();
   }

   public void Draw(Canvas parCanvas)
   {
      parCanvas.drawBitmap(FAnimations.get(FCurrentAnimation).GetActualImage(), getAbsoluteX(), getAbsoluteY(), null);
   }

   public void StartAnimation(int parCurrentAnimation)
   {
      FCurrentAnimation = parCurrentAnimation;
      FAnimations.get(FCurrentAnimation).Start();
   }

   public void AddAnimation(Animation parAnimation)
   {
      FAnimations.add(parAnimation);
      parAnimation.SetEntity(this);
   }
}
