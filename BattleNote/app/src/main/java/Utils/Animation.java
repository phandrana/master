package Utils;

import android.graphics.Bitmap;
import components.Entity;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by phandrana on 08/07/2017.
 */
public class Animation
{
   boolean FStart;

   int FFrameNumber;
   int FFrameCursor;
   int FFrameWidth;
   int FFrameHeight;
   Bitmap FBitmap;
   Delay FDelayNextFrame;
   int FFrameShiftX;
   int FFrameShiftY;
   int FAlignment;

   //TMP ? trouver un autre nom
   int FWidth;
   int FHeight;

   //AnimationTrigger FAnimationTrigger; Will see

   Animation FNextAnimation;
   Entity FEntity;

   public Animation(Bitmap parBitmap, int parFrameNumber, int parFrameWidth, int parFrameHeight, int parAlignment)
   {
      FBitmap = parBitmap;
      FFrameNumber = parFrameNumber;
      FFrameCursor = 0;
      FFrameWidth = parFrameWidth;
      FFrameHeight = parFrameHeight;
      FDelayNextFrame = new Delay(100); //HARDCODED, global? parametrable?
      FStart = false;

      if(parAlignment == Global.VERTICAL)
      {
         FFrameShiftX = 0;
         FFrameShiftY = parFrameHeight;
      }
      else
      {
         FFrameShiftX = parFrameWidth;
         FFrameShiftY = 0;
      }

      FAlignment = parAlignment;

      FWidth = FFrameWidth;
      FHeight = FFrameHeight;

      FNextAnimation = null;
   }

   public void Start()
   {
      FStart = true;
      FFrameCursor = 0;
   }

   public void SetEntity(Entity parEntity)
   {
      FEntity = parEntity;
   }

   public Bitmap GetActualImage()
   {
      boolean resetDelay = false;

      if(FDelayNextFrame.IsFinished())
      {
         FFrameCursor = (FFrameCursor + 1) % FFrameNumber;
         resetDelay = true;

         if(FNextAnimation != null && FFrameCursor == 0)
         {
            FEntity.StartAnimation(0);
            return FNextAnimation.GetActualImage(); //paboooooo
         }
      }

      int ax = FFrameCursor * FFrameShiftX;
      int ay = FFrameCursor * FFrameShiftY;

      Bitmap out = Helper.GetCroppedBitmap(FBitmap, ax, ay, FFrameWidth, FFrameHeight);
      out = Helper.Resize(out, FWidth, FHeight);
      //On reset le delay le plus tard possible
      if(FStart || resetDelay)
      {
         FStart = false;
         FDelayNextFrame.Start();
      }

      return out;
   }

   public void ResizeHeight(int parNewHeight) //TMP ?
   {
      float scale = ((float) parNewHeight) / ((float) FFrameHeight);
      FWidth = (int) (FFrameWidth * scale);
      FHeight = parNewHeight;
   }

   public void SetNextAnimation(Animation parAnimation)
   {
      FNextAnimation = parAnimation;
   }
}
