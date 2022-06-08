import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase de objetos tipo radiación
 * 
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Radiacion extends Actor
{
    protected int energia;
    protected int dir;
    
    /**
     * Constructor por default de la clase Radiacion
     */
    public Radiacion()
    {
        energia = 1;
        dir = Greenfoot.getRandomNumber(360);
        setRotation(dir);
    }
    
    /**
     * Act - do whatever the Radiacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(energia);

        if(isAtEdge())
            // getWorld().removeObject(this);
            rebota();
    }

    /**
     * Hace que el objeto rebote desde el borde del mundo
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

    /**
     * Función para establecer la energía de este objeto
     * @param e la energia que se va a establecer
     */
    protected void setEnergia(int e)
    {
        energia = e;
    }

    /**
     * Funcion para obtener la energía de este objeto
     * @return energia del objeto
     */
    public int getEnergia()
    {
        return energia;
    }
}
