package cosmo.input;

import de.hardcode.jxinput.Axis;
import de.hardcode.jxinput.event.JXInputAxisEvent;
import de.hardcode.jxinput.event.JXInputAxisEventListener;

public class InputControllerAxis implements JXInputAxisEventListener
{
    public InputControllerAxis(Axis axis)
    {
        System.out.println("CONTROLLER axis");
    }

    @Override
    public void changed(JXInputAxisEvent event)
    {
        System.out.println("CONTROLLER axis - " + event);
    }
}