package components;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by phandrana on 08/07/2017.
 */
public class Component
{
   int FX, FY;
   Component FParent;
   protected Paint FPaint;

   public Component(int parX, int parY)
   {
      FX = parX;
      FY = parY;
      FParent = null;
      FPaint = new Paint();
   }

   public void setParent(Component parParent)
   {
      FParent = parParent;
   }

   public int getRelativeX()
   {
      return FX;
   }

   public int getRelativeY()
   {
      return FY;
   }

   public int getAbsoluteX()
   {
      int shiftX = 0;

      if(FParent != null)
      {
         shiftX = FParent.getAbsoluteX();
      }

      return FX + shiftX;
   }

   public int getAbsoluteY()
   {
      int shiftY = 0;

      if(FParent != null)
      {
         shiftY = FParent.getAbsoluteY();
      }

      return FY + shiftY;
   }

   public void SetX(int parX)
   {
      FX = parX;
   }

   public void SetY(int parY)
   {
      FY = parY;
   }

   public void Draw(Canvas parCanvas)
   {
      //Méthode abstraite
   }
}
