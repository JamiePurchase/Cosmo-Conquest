package cosmo.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeyboard implements KeyListener
{
    // New
    public static InputKeyboardKey keyUp, keyDown, keyLeft, keyRight, keySpace;
    
    private static String keyPressed = "NONE";
    private static boolean keyPressedNow = false;
    private static boolean keyPressedAlpha = false;
    private static String keyReleased = "NONE";
    private static boolean keyReleasedEvent = false;
    private boolean keyModifierAlt = false;
    private boolean keyModifierShift = false;
    
    public InputKeyboard()
    {
        keyUp = new InputKeyboardKey();
        keyDown = new InputKeyboardKey();
        keyLeft = new InputKeyboardKey();
        keyRight = new InputKeyboardKey();
        keySpace = new InputKeyboardKey();
    }

    public static String getKeyPressed()
    {
            return keyPressed;
    }

    public static boolean getKeyPressedAlpha()
    {
            return keyPressedAlpha;
    }
    
    public static boolean getKeyPressedNow()
    {
        return keyPressedNow;
    }

    public static String getKeyReleased()
    {
            return keyReleased;
    }

    public boolean getModifierPressed(String key)
    {
            if(key=="ALT") {return keyModifierAlt;}
            if(key=="SHIFT") {return keyModifierShift;}
            return false;
    }

    public void keyTyped(KeyEvent e)
    {
        //System.out.println("Key typed: " + e.getKeyChar());
    }

    public void keyPressed(KeyEvent e)
    {
        //System.out.println("Key pressed: " + e.getKeyChar());
        this.keyPressedNow = true;
        if(e.getKeyCode() == KeyEvent.VK_ENTER){keyPressed = "ENTER";}
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keyPressed = "SPACE";
            this.keySpace.press();
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){keyPressed = "ESCAPE";}
        if(e.getKeyCode() == KeyEvent.VK_HOME){keyPressed = "HOME";}
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            keyPressed = "UP";
            this.keyUp.press();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keyPressed = "DOWN";
            this.keyDown.press();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keyPressed = "LEFT";
            this.keyLeft.press();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keyPressed = "RIGHT";
            this.keyRight.press();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){keyPressed = "A";}
        if(e.getKeyCode() == KeyEvent.VK_D){keyPressed = "D";}
        if(e.getKeyCode() == KeyEvent.VK_E){keyPressed = "E";}
        if(e.getKeyCode() == KeyEvent.VK_S){keyPressed = "S";}
        if(e.getKeyCode() == KeyEvent.VK_Q){keyPressed = "Q";}
        if(e.getKeyCode() == KeyEvent.VK_W){keyPressed = "W";}
        
        // Temp
        if(e.getKeyCode() == KeyEvent.VK_ALT){keyModifierAlt = true;}
        if(e.getKeyCode() == KeyEvent.VK_SHIFT){keyModifierAlt = true;}
        
        // NOTE: Do some checks and set keyPressedAlpha to true if a letter was typed
        //System.out.println("keyboard pressed: " + e.getKeyCode());
        //System.out.println("Variable keyPressed: " + keyPressed);
    }

    public void keyReleased(KeyEvent e)
    {
        //System.out.println("Key released: " + e.getKeyChar());
        this.keyReleasedEvent = true;
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keyPressed = "SPACE";
            this.keySpace.release();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            keyReleased = "UP";
            this.keyUp.release();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keyReleased = "DOWN";
            this.keyDown.release();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keyReleased = "LEFT";
            this.keyLeft.release();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keyReleased = "RIGHT";
            this.keyRight.release();
        }
        if(e.getKeyCode() == KeyEvent.VK_A){keyReleased = "A";}
        if(e.getKeyCode() == KeyEvent.VK_D){keyReleased = "D";}
        if(e.getKeyCode() == KeyEvent.VK_E){keyReleased = "E";}
        if(e.getKeyCode() == KeyEvent.VK_S){keyReleased = "S";}
        if(e.getKeyCode() == KeyEvent.VK_Q){keyReleased = "Q";}
        if(e.getKeyCode() == KeyEvent.VK_W){keyReleased = "W";}
        
        // Temp
        if(e.getKeyCode() == KeyEvent.VK_ALT){keyModifierAlt = false;}
        if(e.getKeyCode() == KeyEvent.VK_SHIFT){keyModifierAlt = false;}
    }
    
    public static void keyPressedDone()
    {
            keyPressed = "NONE";
            keyPressedNow = false;
    }

    public static void keyReleasedDone()
    {
            keyReleased = "NONE";
            keyReleasedEvent = false;
    }
}