package panels;

import Utils.Helper;
import com.example.phandrana.battlenote.R;
import components.Button;
import components.Component;
import components.Container;
import components.Image;

/**
 * Created by phandrana on 08/07/2017.
 */
public class InputNotePanel extends Container
{
   public InputNotePanel(int parX, int parY, int parWidth, int parHeight)
   {
      super(parX, parY, parWidth, parHeight);

      int buttonSizeX = parWidth / 6;
      int buttonSizeY = parHeight / 6;

      int gapXForThreeButtons = (parWidth - (buttonSizeX * 5)) / 2;
      int gapXFoOneButtons = (parWidth - buttonSizeX) / 2;

      int gapY = (parHeight - (buttonSizeY * 5)) / 2;

      Image doImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.dobutton));
      doImage.Resize(buttonSizeX, buttonSizeY);

      Image reImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.rebutton));
      reImage.Resize(buttonSizeX, buttonSizeY);

      Image miImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.mibutton));
      miImage.Resize(buttonSizeX, buttonSizeY);

      Image faImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.fabutton));
      faImage.Resize(buttonSizeX, buttonSizeY);

      Image solImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.solbutton));
      solImage.Resize(buttonSizeX, buttonSizeY);

      Image laImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.labutton));
      laImage.Resize(buttonSizeX, buttonSizeY);

      Image siImage = new Image(0, 0, Helper.ExtractBitmap(R.drawable.sibutton));
      siImage.Resize(buttonSizeX, buttonSizeY);


      Button doButton = new Button(gapXForThreeButtons, gapY, doImage, 8);
      Button reButton = new Button(gapXForThreeButtons + (2 * buttonSizeX), gapY, reImage, 4);
      Button miButton = new Button(gapXForThreeButtons + (4 * buttonSizeX), gapY , miImage, 2);

      Button faButton = new Button(gapXForThreeButtons, gapY + (2 * buttonSizeY), faImage, 1);
      Button solButton = new Button(gapXForThreeButtons + (2 * buttonSizeX), gapY + (2 * buttonSizeY), solImage, 64);
      Button laButton = new Button(gapXForThreeButtons + (4 * buttonSizeX), gapY + (2 * buttonSizeY) , laImage, 32);

      Button siButton = new Button(gapXFoOneButtons, gapY + (4 * buttonSizeY), siImage, 16);

      addComponent(doButton);
      addComponent(reButton);
      addComponent(miButton);

      addComponent(faButton);
      addComponent(solButton);
      addComponent(laButton);

      addComponent(siButton);
   }

   public int GetSignal(int parX, int parY)
   {
      int signal = 0;

      for(Component c : FComponents)
      {
         signal |= ((Button) c).GetSignal(parX, parY);
      }

      if(signal == 0)
      {
         SetDisplayButtons(false);
      }

      return signal;
   }

   public void SetDisplayButtons(boolean parDisplay)
   {
      for(Component c : FComponents)
      {
         ((Button) c).FNoDisplay = parDisplay;
      }
   }
}
