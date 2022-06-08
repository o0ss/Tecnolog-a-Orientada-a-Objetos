import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Escena del nivel 3
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Nivel3 extends Nivel
{

    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3()
    {
        super(10, 10, 4, 5, 3);
        AtomoPlayer atomoPlayer = new AtomoPlayer(124,124,124);
        atomoPlayer.setNivel(3);
        addObject(atomoPlayer, WIDTH/2, HEIGHT/2);
        setNivelNum(3);
        music.play();
    }
}
