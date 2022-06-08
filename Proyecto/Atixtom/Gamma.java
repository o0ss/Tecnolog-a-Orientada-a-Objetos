import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Radiación de tipo gamma que destruye átomos
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Gamma extends Photon
{

    /**
     * Constructor por default de la clase Gamma
     */
    public Gamma()
    {
        setEnergia(Greenfoot.getRandomNumber(6)+4);

        GreenfootImage img = getImage();
        img.scale(30, 10);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Gamma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
}
