package Utils;

import java.util.ArrayList;

/**
 * Created by phandrana on 09/07/2017.
 */
public class AnimationTrigger
{
   int FAnimationToTrigger;
   int FFrameTrigger;
   ArrayList<Animation> FAnimationsTriggerable;
   Animation FNextAnimation;

   public AnimationTrigger(int parFrameTrigger )
   {
      FAnimationToTrigger = -1;
      FFrameTrigger = parFrameTrigger;
   }

   public void AddAnimationToTrigger(Animation parAnimationToTrigger)
   {

   }
}
