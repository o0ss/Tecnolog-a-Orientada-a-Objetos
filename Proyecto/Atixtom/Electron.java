import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Electrones que componen los átomos y se mueven por el escenario libremente
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Electron extends Particula
{
    /**
     * Constructor por default del electrón
     */
    public Electron()
    {
        GreenfootImage img = getImage();
        img.scale(10, 10);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Electron wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(energia);
        super.act();
    }
}
