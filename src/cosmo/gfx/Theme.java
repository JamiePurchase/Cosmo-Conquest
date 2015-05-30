package cosmo.gfx;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class Theme
{
    private Map<String, Color> pallete;
    private Map<String, Font> typeface;

    public Theme()
    {
        // Colour Pallette
        this.pallete = new HashMap<String, Color>();
        pallete.put("BACK" , Drawing.getColorRGB(75, 99, 52));
        pallete.put("BARENERGY", Drawing.getColorRGB(82, 108, 57));
        pallete.put("BARHEALTH", Drawing.getColorRGB(208, 34, 9));
        pallete.put("FORE" , Drawing.getColorRGB(82, 108, 57));
        pallete.put("MAPALLY", Drawing.getColorRGB(82, 108, 57));
        pallete.put("MAPENEMY", Drawing.getColorRGB(208, 34, 9));
        pallete.put("MAPOBJECTIVE", Drawing.getColorRGB(231, 174, 41));
        pallete.put("SHADOW", Drawing.getColorRGB(50, 67, 50));
        pallete.put("STANDARD", Drawing.getColorRGB(0, 0, 0));
        pallete.put("TEXT", Drawing.getColorRGB(0, 0, 0));
        
        // Typeface Styles
        this.typeface = new HashMap<String, Font>();
        typeface.put("HEADER", new Font("Trebuchet MS", Font.BOLD, 22));
        typeface.put("MESSAGE", new Font("Trebuchet MS", Font.PLAIN, 22));
        typeface.put("PLAIN", new Font("Courier New", Font.PLAIN, 18));
        typeface.put("STANDARD", new Font("Trebuchet MS", Font.PLAIN, 18));
    }
    
    public void addColour(String id, Color color)
    {
        pallete.put(id, color);
    }
    
    public void addFont(String id, Font font)
    {
        typeface.put(id, font);
    }
    
    public Color getColour(String id)
    {
        return pallete.get(id);
    }
    
    public Font getFont(String id)
    {
        return typeface.get(id);
    }
    
}