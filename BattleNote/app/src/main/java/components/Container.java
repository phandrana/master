package components;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by phandrana on 08/07/2017.
 */
public class Container extends Component
{
   protected int FWidth, FHeight;
   protected ArrayList<Component> FComponents;

   public Container(int parX, int parY, int parWidth, int parHeight)
   {
      super(parX, parY);

      FWidth = parWidth;
      FHeight = parHeight;
      FComponents = new ArrayList<>();
   }

   public void addComponent(Component parComponent)
   {
      FComponents.add(parComponent);

      parComponent.setParent(this);
   }

   @Override
   public void Draw(Canvas parCanvas)
   {
      for(Component c : FComponents)
      {
         c.Draw(parCanvas);
      }
   }
}
