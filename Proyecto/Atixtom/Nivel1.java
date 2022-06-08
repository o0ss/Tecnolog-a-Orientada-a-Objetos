import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Escena del nivel 1
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Nivel1 extends Nivel
{

    /**
     * Constructor for objects of class Nivel1.
     * 
     */
    public Nivel1()
    {
        super(10, 10, 8, 2, 1);
        AtomoPlayer atomoPlayer = new AtomoPlayer(40, 40, 40);
        atomoPlayer.setNivel(1);
        addObject(atomoPlayer, WIDTH/2, HEIGHT/2);
        setNivelNum(1);
        music.play();
    }
    
}
