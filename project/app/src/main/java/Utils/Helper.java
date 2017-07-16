package Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static flow.Game.SGameFlow;

public class Helper
{
   public static Bitmap ExtractBitmap(int parID)
   {
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inScaled = false;

      return BitmapFactory.decodeResource(SGameFlow.getResources(), parID, options);
   }

   public static Bitmap ResizeWidth(Bitmap parBitmap, int parNewWidth)
   {
      float scale = ((float) parNewWidth) / ((float) parBitmap.getHeight());
      int newHeight = (int) (parBitmap.getHeight() * scale);

      return Bitmap.createScaledBitmap(parBitmap, parNewWidth, newHeight, true);
   }

   public static Bitmap ResizeHeight(Bitmap parBitmap, int parNewHeight)
   {
      float scale =  ((float) parNewHeight) / ((float) parBitmap.getHeight());
      int newWidth = (int) (((float) parBitmap.getWidth()) * scale);

      return Bitmap.createScaledBitmap(parBitmap, newWidth, parNewHeight, true);
   }

   public static Bitmap Resize(Bitmap parBitmap, int parNewWidth, int parNewHeight)
   {
      return Bitmap.createScaledBitmap(parBitmap, parNewWidth, parNewHeight, true);
   }

   public static Bitmap GetCroppedBitmap(Bitmap parBitmap, int parAx, int parAy, int parWidth, int parHeight)
   {
      return Bitmap.createBitmap(parBitmap, parAx, parAy, parWidth, parHeight);
   }
}
