package components;

import android.graphics.*;

/**
 * Created by phandrana on 08/07/2017.
 */
public class Button extends Component
{
   Image FImage;
   int FSignal;
   public boolean FNoDisplay;

   public Button(int parX, int parY, Image parImage, int parSignal)
   {
      super(parX, parY);
      int width = parImage.getWidth();
      FImage = parImage;
      FImage.setParent(this);
      FSignal = parSignal;
      FNoDisplay = false;
   }

   public int GetSignal(int parX, int parY)
   {
      int width = FImage.getWidth();
      int height = FImage.getHeight();

      if((parX >= getAbsoluteX() && parX <= getAbsoluteX() + width) && (parY >= getAbsoluteY() && parY <= getAbsoluteY() + height))
      {
         return FSignal;
      }

      FNoDisplay = true;

      return 0;
   }

   @Override
   public void Draw(Canvas parCanvas)
   {
      if(FNoDisplay)
         return;

      FImage.Draw(parCanvas);
   }
}
