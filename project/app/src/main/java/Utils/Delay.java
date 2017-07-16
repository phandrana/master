package Utils;

/**
 * Created by phandrana on 08/07/2017.
 */
public class Delay
{
   boolean FIsOn;
   int FDuration;
   long FStart;

   public Delay(int parDuration)
   {
      FIsOn = false;
      FDuration = parDuration;
   }

   public void Start()
   {
      FIsOn = true;
      FStart = GetTimeMillisecond();
   }

   public boolean IsFinished()
   {
      if(!FIsOn)
         return false;

      if((GetTimeMillisecond() - FStart >= FDuration))
      {
         FIsOn = false;

         return true;
      }

      return false;
   }

   public static long GetTimeMillisecond()
   {
      return (System.nanoTime() / 1000000);
   }
}
