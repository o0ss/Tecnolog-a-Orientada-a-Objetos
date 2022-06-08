import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Radiación en fotones
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Photon extends Radiacion
{
    /**
     * Constructor por default de la clase Photon
     */
    public Photon()
    {
        GreenfootImage img = getImage();
        img.scale(100,20);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Photon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
}
