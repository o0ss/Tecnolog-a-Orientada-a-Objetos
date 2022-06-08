import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase del objeto que va a controlar el jugador
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class AtomoPlayer extends Atomo
{
    private int nivel = 1;

    /**
     * Constructor de la clase AtomoPlayer
     * @param e electrones
     * @param p protones
     * @param n neutrones
     */
    public AtomoPlayer(int e, int p, int n)
    {
        super(e, p, n);
    }
    /**
     * Act - do whatever the AtomoPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        control();
        
        if(isTouching(Atomo.class)) rebota();
        else move(1);

        if(Nivel.probabilidad(nivel*3+2))
        {
            ((Nivel)getWorld()).generaGamma();
        }
        
        if(isTouching(Neutron.class))
        {
            ((Nivel)getWorld()).s1.play();
            absorbeNeutron();
        }
        else if(isTouching(Proton.class))
        {
            ((Nivel)getWorld()).s2.play();
            absorbeProton();
        }
        else if(isTouching(Electron.class))
        {
            ((Nivel)getWorld()).s1.play();
            absorbeElectron();
        }
        else if(isTouching(Gamma.class))
        {
            ((Nivel)getWorld()).gm.play();
            absorbeGamma();
        }
    }

    /**
     * Establece en qué nivel está el jugador
     * @param nivel
     */
    public void setNivel(int nivel)
    {
        this.nivel = nivel;
    }

    /**
     * Controla el movimiento del personaje principal 
     * con el teclado
     */
    public boolean control()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            moveDir(DER);
            return true;
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            moveDir(IZQ);
            return true;
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            moveDir(UP);
            return true;
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            moveDir(DOWN);
            return true;
        }
        else return false;
    }

    /**
     * Mueve el personaje principal en la direccion dir
     */
    public void moveDir(int dir)
    {
        setRotation(dir);
        if(Greenfoot.isKeyDown("space"))
            move(6);
        else
            move(3);
    }


    /**
     * Absorbe radiación gamma
     */
    public void absorbeGamma()
    {
        int newP, newN, newE;
        
        removeTouching(Gamma.class);
        if(protons < 3 || neutrons < 3)
        {
            Nivel nv = (Nivel) getWorld();
            for (int i = 0; i < protons; i++) {
                Proton p = new Proton();
                nv.addObject(p, getX(), getY());
                addProtones(-1);
            }
            for (int i = 0; i < neutrons; i++) {
                Neutron n = new Neutron();
                nv.addObject(n, getX(), getY());
                addNeutrones(-1);
            }
            for (int i = 0; i < electrons; i++) {
                Electron e = new Electron();
                nv.addObject(e, getX(), getY());
                addElectrones(-1);
            }
        }
        else{
            newP = protons / 4;
            newN = neutrons / 4;
            newE = electrons / 4;
            protons -= newP;
            neutrons -= newN;
            electrons -= newE;
            // addEnergia(1);

            Atomo newAtom = new Atomo(newE, newP, newN);
            getWorld().addObject(newAtom, getX()+5, getY()+5);
            
            Nivel n = (Nivel) getWorld();
            n.generaGamma();
        }
        actualizaTamanno();
    }

    

    /**
     * Actualiza el tamaño de la imagen del objeto según
     * la masa del átomo
     */
    public void actualizaTamanno()
    {
        int p = getProtones(), n = getNeutrones();
        
        int masa = p + n;

        if(masa <= 0)
        {
            ((Nivel)getWorld()).l_change.play();
            Greenfoot.setWorld(new GameOver());
        }

        int size = (int) Math.pow((double) masa, 0.72);
        size = size < 20 ? 20 : size;

        GreenfootImage img = new GreenfootImage("atom.png");
        img.scale(size, size);
        setImage(img);

        if (masa > 60*2 && nivel == 1) {
            setNivel(2);
            ((Nivel)getWorld()).l_change.play();
            Greenfoot.setWorld(new Nivel2());
        }

        if (masa > 110*2 && nivel == 2) {
            setNivel(3);
            ((Nivel)getWorld()).l_change.play();
            Greenfoot.setWorld(new Nivel3());
        }

        if(masa > 300 && nivel == 3) {
            ((Nivel)getWorld()).l_change.play();
            Greenfoot.setWorld(new Win());
        }
    }
}
