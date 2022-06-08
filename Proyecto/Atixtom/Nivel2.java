import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Escena del nivel 2
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Nivel2 extends Nivel
{

    /**
     * Constructor for objects of class Nivel2.
     * 
     */
    public Nivel2()
    {
        super(5, 5, 7, 4, 2);
        AtomoPlayer atomoPlayer = new AtomoPlayer(80,80,80);
        atomoPlayer.setNivel(2);
        addObject(atomoPlayer, WIDTH/2, HEIGHT/2);
        setNivelNum(2);
        music.play();
    }
}
