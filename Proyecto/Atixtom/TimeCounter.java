import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contador que muestra el temporizador
 * 
 * @author Oscar Sixtos
 * @version 05-06-2022
 */
public class TimeCounter extends Counter
{
    private long inicio;

    /**
     * Constructor de la clase TimeCounter
     * @param tiempo el tiempo en segundos con el que va a comenzar el temporizador
     */
    public TimeCounter(int tiempo)
    {
        super("Tiempo: ");
        inicio = System.currentTimeMillis();

        setValue(tiempo);
    }

    /**
     * Act - do whatever the TimeCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(System.currentTimeMillis()-inicio >= 1000)
        {
            add(-1);
            inicio = System.currentTimeMillis();
        }
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
        if(getValue() <= 0)
        {
            ((Nivel)getWorld()).l_change.play();
            Greenfoot.setWorld(new GameOver());
        }
    }
}
