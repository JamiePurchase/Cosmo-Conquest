package cosmo.input;

import de.hardcode.jxinput.Button;
import de.hardcode.jxinput.event.JXInputButtonEvent;
import de.hardcode.jxinput.event.JXInputButtonEventListener;

public class InputControllerButton implements JXInputButtonEventListener
{
    public InputControllerButton(Button button)
    {
        System.out.println("CONTROLLER button");
    }

    @Override
    public void changed(JXInputButtonEvent event)
    {
        System.out.println("CONTROLLER button - " + event);
    }
}