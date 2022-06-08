import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que hereda propiedades a los protones, neutrones y electrones
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Particula extends Actor
{
    protected int energia;
    protected int dir;

    /**
     * Constructor de la clase Particula
     */
    public Particula()
    {
        super();
        energia = 1;
        dir = Greenfoot.getRandomNumber(360);
        setRotation(dir);
    }
    
    /**
     * Act - do whatever the Particula wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isAtEdge())
            // getWorld().removeObject(this);
            rebota();
    }

    /**
     * Incrementa la energía en qty unidades
     * @param qty
     */
    public void addEnergia(int qty)
    {
        energia += qty;
        energia = energia < 0 ? 0 : energia;
    }

    /**
     * Regresa la energía de la partícula
     * @return la energía
     */
    public int getEnergia()
    {
        return energia;
    }

    /**
     * Rebota la partícula en una dirección aleatoria
     */
    public void rebota()
    {
        setRotation(Greenfoot.getRandomNumber(360));
        dir = getRotation();
        int w = getImage().getWidth(), h = getImage().getHeight();
        int x = w < h ? h : w;
        x /= 2;

        for (int i = 0; i <= x; i++) {
            move(1);
        }
    }
}
