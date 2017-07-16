package panels;

import Utils.Global;
import Utils.Helper;
import android.graphics.Canvas;
import android.graphics.Color;
import com.example.phandrana.battlenote.R;
import components.Container;
import components.Image;

import java.util.ArrayList;

import static flow.Game.SGameFlow;

/**
 * Created by phandrana on 09/07/2017.
 */
public class MusicSheetPanel extends Container
{
   Image FTrebleNoteImage;
   Image FNoteImage;
   int FNoteValue;
   float FStaffGapY;
   ArrayList<Integer> FNextNotes;

   public MusicSheetPanel(int parX, int parY, int parWidth, int parHeight)
   {
      super(parX, parY, parWidth, parHeight);

      FStaffGapY = ((float) parHeight) / 7.f;

      int notePositionY = parWidth / 4;

      FTrebleNoteImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.trebleclef));
      FTrebleNoteImage.ResizeHeight(parHeight);

      FNoteImage = new Image(notePositionY, -1, Helper.ExtractBitmap(R.drawable.wholenote));
      FNoteImage.ResizeHeight((int) FStaffGapY);

      FNextNotes = new ArrayList();
      for(int i = 0; i < Global.NOTE_POSITION_NUMBER; ++i)
      {
         FNextNotes.add(i);
      }

      addComponent(FTrebleNoteImage);
      addComponent(FNoteImage);

      RandomizeNote();
   }

   @Override
   public void Draw(Canvas parCanvas)
   {
      super.Draw(parCanvas);

      //Pour dessiner la portée
      float gapy = FStaffGapY;

      FPaint.setColor(Color.BLACK);

      for(int i = 0; i < 5; ++i)
      {
         gapy += FStaffGapY;
         parCanvas.drawLine(0, (int) gapy, FWidth, (int) gapy, FPaint);
      }
   }

   public void RandomizeNote()
   {
      int iNoteValue = (int) (Math.random() * FNextNotes.size());
      int oldNoteValue = FNoteValue;
      int newNoteValue = FNextNotes.get(iNoteValue);

      FNextNotes.remove(iNoteValue);
      FNextNotes.add(oldNoteValue);

      SetNoteValueAndPosition(newNoteValue);
   }

   public void IncrementNote()
   {
      SetNoteValueAndPosition((FNoteValue + 1) % Global.NOTE_POSITION_NUMBER );
   }

   private void SetNoteValueAndPosition(int parNoteValue)
   {
      FNoteValue = parNoteValue;

      float shiftY = FStaffGapY + (FStaffGapY / 2); //Pour 9 positions de note
      float positionY = FNoteValue * (FStaffGapY / 2);

      FNoteImage.SetY((int) (positionY + shiftY));
   }

   public boolean SendSignal(int parSignal)
   {
      int calcul = (FNoteValue % 7);

      int value = ((int) Math.pow((double) 2, (double) calcul));

      return value == parSignal;
   }

}
