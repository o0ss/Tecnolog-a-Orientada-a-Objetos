import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Contador que muestra el número de partículas que contiene
 * el átomo controlado por el jugador
 * 
 * @author Oscar Sixtos
 * @version 04-06-2022
 */
public class ParticulaCounter extends Counter
{
    public static final int NEUTRON = 0;
    public static final int PROTON = 1;
    public static final int ELECTRON = 2;
    
    private int tipo_p = 0;
    
    /**
     * Constructor de la clase ParticulaCounter
     * @param tipo el tipo de partícula que va a contar
     */
    public ParticulaCounter(int tipo)
    {   
        super();
        switch (tipo) {
            case NEUTRON:
                setPrefix("N: ");
                tipo_p = tipo;
                break;

            case PROTON:
                setPrefix("P: ");
                tipo_p = tipo;
                break;
            
            case ELECTRON:
                setPrefix("e: ");
                tipo_p = tipo;
                break;
        
            default:
                break;
        }

    }
    
    /**
     * Act - do whatever the ParticulaCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        List<AtomoPlayer> p = getWorld().getObjects(AtomoPlayer.class);
        switch (tipo_p) {
            case NEUTRON:
                update(p.get(0).getNeutrones());
                break;

            case PROTON:
            update(p.get(0).getProtones());
                break;
            
            case ELECTRON:
                update(p.get(0).getElectrones());
                break;
        
            default:
                break;
        }

        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    /**
     * Actualiza el valor del contador al número proporcionado.
     */
    public void update(int score)
    {
        target = score;
    }
}
