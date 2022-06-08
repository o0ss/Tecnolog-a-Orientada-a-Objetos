import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Escena para una partida completada
 * 
 * @author Oscar Sixtos
 * @version 05-06-2022
 */
public class Win extends Nivel
{

    /**
     * Constructor for objects of class Win.
     * 
     */
    public Win()
    {
        super(1,1,1,1,1);
        removeObjects(getObjects(null));
        prepare(10, 10, 5, 3);
    }

    /**
     * Inicializa la escena Win
     * @param protons
     * @param neutrons
     * @param atoms
     * @param gamma
     */
    private void prepare(int protons, int neutrons, int atoms, int gamma)
    {
        for (int i = 0; i < Greenfoot.getRandomNumber(neutrons)+neutrons/2; i++) {
            Neutron n = new Neutron();
            addObject(n, 
                      Greenfoot.getRandomNumber(Nivel.WIDTH)+5, 
                      Greenfoot.getRandomNumber(Nivel.HEIGHT)+5);
        }
        
        for (int i = 0; i < Greenfoot.getRandomNumber(protons)+protons/2; i++) {
            Proton p = new Proton();
            addObject(p, 
                      Greenfoot.getRandomNumber(Nivel.WIDTH)+5, 
                      Greenfoot.getRandomNumber(Nivel.HEIGHT)+5);
        }

        for (int i = 0; i < Greenfoot.getRandomNumber(2*protons)+protons; i++) {
            Electron e = new Electron();
            
            addObject(e, 
                      Greenfoot.getRandomNumber(Nivel.WIDTH)+5, 
                      Greenfoot.getRandomNumber(Nivel.HEIGHT)+5);
        }

        for (int i = 0; i < Greenfoot.getRandomNumber(gamma)+gamma/2; i++) {
            Gamma g = new Gamma();
            addObject(g, 
                      Greenfoot.getRandomNumber(Nivel.WIDTH)+5, 
                      Greenfoot.getRandomNumber(Nivel.HEIGHT)+5);
        }
        
        for (int i = 0; i < Greenfoot.getRandomNumber(atoms)+atoms/2; i++) {
            Atomo a = new Atomo();
            addObject(a, 
                      Greenfoot.getRandomNumber(Nivel.WIDTH)+5, 
                      Greenfoot.getRandomNumber(Nivel.HEIGHT)+5);
        }
    }
}
