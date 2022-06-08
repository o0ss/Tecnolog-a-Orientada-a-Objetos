import java.util.ArrayList;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que hereda propiedades a los demás niveles
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Nivel extends World
{
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 700;

    private int nivel_num;
    public GreenfootSound music = new GreenfootSound("music.mp3");
    public GreenfootSound s1 = new GreenfootSound("S1.mp3");
    public GreenfootSound s2 = new GreenfootSound("S2.mp3");
    public GreenfootSound gm = new GreenfootSound("gamma.mp3");
    public GreenfootSound l_change = new GreenfootSound("l_change.mp3");
    
    /**
     * Constructor for objects of class Nivel.
     * 
     */
    public Nivel(int protons, int neutrons, int atoms, int gamma, int nivel)
    {    
        // Create a new world with WIDTH x HEIGHT cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
        setNivelNum(nivel);
        prepare( protons, neutrons, atoms, gamma);
    }

    /**
     * Establece el número del nivel
     * @param niv número del nivel
     */
    public void setNivelNum(int niv)
    {
        nivel_num = niv;
    }

    /**
     * Obtiene el número del nivel
     * @return nivel
     */
    public int getNivelNum()
    {
        return nivel_num;
    }

    /**
     * Regresa verdadero con un porciento de probabilidad
     */
    public static boolean probabilidad(int porciento)
    {
        return Greenfoot.getRandomNumber(100) < porciento;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare(int protons, int neutrons, int atoms, int gamma)
    {
        for (int i = 0; i < Greenfoot.getRandomNumber(neutrons)+neutrons/2; i++) {
            Neutron n = new Neutron();
            addObject(n, 
                      Greenfoot.getRandomNumber(WIDTH)+5, 
                      Greenfoot.getRandomNumber(HEIGHT)+5);
        }
        
        for (int i = 0; i < Greenfoot.getRandomNumber(protons)+protons/2; i++) {
            Proton p = new Proton();
            addObject(p, 
                      Greenfoot.getRandomNumber(WIDTH)+5, 
                      Greenfoot.getRandomNumber(HEIGHT)+5);
        }

        for (int i = 0; i < Greenfoot.getRandomNumber(2*protons)+protons; i++) {
            Electron e = new Electron();
            
            addObject(e, 
                      Greenfoot.getRandomNumber(WIDTH)+5, 
                      Greenfoot.getRandomNumber(HEIGHT)+5);
        }

        for (int i = 0; i < Greenfoot.getRandomNumber(gamma)+gamma/2; i++) {
            Gamma g = new Gamma();
            addObject(g, 
                      Greenfoot.getRandomNumber(WIDTH)+5, 
                      Greenfoot.getRandomNumber(HEIGHT)+5);
        }
        
        for (int i = 0; i < Greenfoot.getRandomNumber(atoms)+atoms/2; i++) {
            Atomo a = new Atomo();
            addObject(a, 
                      Greenfoot.getRandomNumber(WIDTH)+5, 
                      Greenfoot.getRandomNumber(HEIGHT)+5);
        }

        int segs;
        switch (getNivelNum()) {
            case 1:
                segs = 90;
                break;
            case 2:
                segs = 80;
                break;
            case 3:
                segs = 77;
                break;
            default:
                segs = 60;
                break;
        }
        TimeCounter timer = new TimeCounter(segs);
        addObject(timer, 1130, 20);

        ParticulaCounter counter_p = new ParticulaCounter(ParticulaCounter.PROTON);
        ParticulaCounter counter_n = new ParticulaCounter(ParticulaCounter.NEUTRON);
        ParticulaCounter counter_e = new ParticulaCounter(ParticulaCounter.ELECTRON);

        addObject(counter_p, 50, 610);
        addObject(counter_n, 50, 645);
        addObject(counter_e, 50, 680);
    }

    /**
     * Agrega un nuevo electrón al mundo
     */
    public void generaElectron()
    {
        Electron e = new Electron();
        addObject(e, 
                    Greenfoot.getRandomNumber(WIDTH), 
                    Greenfoot.getRandomNumber(HEIGHT));
    }

    /**
     * Agrega un nuevo neutrón al mundo
     */
    public void generaNeutron()
    {
        Neutron n = new Neutron();
        addObject(n, 
                    Greenfoot.getRandomNumber(WIDTH)+5, 
                    Greenfoot.getRandomNumber(HEIGHT)+5);
    }

    /**
     * Agrega un nuevo protón al mundo
     */
    public void generaProton()
    {
    Proton p = new Proton();
    addObject(p, 
                Greenfoot.getRandomNumber(WIDTH)+5, 
                Greenfoot.getRandomNumber(HEIGHT)+5);
    }

    /**
     * Agrega radiación gamma al mundo un 10% de las veces que se llama la función
     */
    public void generaGamma()
    {
        if(probabilidad(10))
        {
            Gamma g = new Gamma();
            addObject(g, 
                        Greenfoot.getRandomNumber(WIDTH)+5, 
                        Greenfoot.getRandomNumber(HEIGHT)+5);
        }
    }
}
