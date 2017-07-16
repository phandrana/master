package components;

import Utils.Helper;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by phandrana on 08/07/2017.
 */
public class Image extends Component
{
   Bitmap FBitmapSource;
   Bitmap FBitmapUsed;

   public Image(int parX, int parY, Bitmap parBitmap)
   {
      super(parX, parY);

      FBitmapSource = parBitmap;
      FBitmapUsed = parBitmap;
   }

   public void ResizeWidth(int parNewWidth)
   {
      FBitmapUsed = Helper.ResizeWidth(FBitmapSource, parNewWidth);
   }

   public void ResizeHeight(int parNewHeight)
   {
      FBitmapUsed = Helper.ResizeHeight(FBitmapSource, parNewHeight);
   }

   public void Resize(int parNewWidth, int parNewHeight)
   {
      FBitmapUsed = Helper.Resize(FBitmapSource, parNewWidth, parNewHeight);
   }

   public void Draw(Canvas parCanvas)
   {
      parCanvas.drawBitmap(FBitmapUsed, getAbsoluteX(), getAbsoluteY(), null);
   }

   public int getWidth()
   {
      return FBitmapUsed.getWidth();
   }

   public int getHeight()
   {
      return FBitmapUsed.getHeight();
   }

   public Bitmap GetBitmap()
   {
      return FBitmapUsed;
   }
}
