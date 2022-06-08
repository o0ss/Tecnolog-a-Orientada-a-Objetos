import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.lang.Math;

/**
 * Átomos que absorben otras partículas y se mueven solos 
 * en el escenario
 * @author Oscar Sixtos
 * @version 03-06-2022
 */
public class Atomo extends Actor
{   
    public static final int DER = 0;
    public static final int IZQ = 180;
    public static final int UP = 270;
    public static final int DOWN = 90;
    
    public int protons;
    public int neutrons;
    public int electrons;
    
    public int dir;
    public int energia;
    
    /**
     * Constructor por default de la clase Atomo
     */
    public Atomo()
    {
        protons = Greenfoot.getRandomNumber(240) + 1;
        neutrons = Greenfoot.getRandomNumber(4) < 2 ? 
                    protons + Greenfoot.getRandomNumber(6):
                    protons - Greenfoot.getRandomNumber(6);
        electrons = protons;
        actualizaTamanno();
        
        energia = Greenfoot.getRandomNumber(10);
        dir = Greenfoot.getRandomNumber(360);
        setRotation(dir);
    }

    /**
     * Construye un átomo con e electrones, p protones y
     * n neutrones
     */
    public Atomo(int e, int p, int n)
    {
        this();
        protons = p;
        neutrons = n;
        electrons = e;
        actualizaTamanno();
    }

    /**
     * Act - do whatever the Atomo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Nivel.probabilidad(1))
            addEnergia(-1);


        if(isTouching(Atomo.class)) rebota();
        else move(energia);

        if(isTouching(Neutron.class))
            absorbeNeutron();
        if(isTouching(Proton.class))
            absorbeProton();
        if(isTouching(Electron.class))
            absorbeElectron();
        
        if(isAtEdge())
            rebotaEdge();

        if(getWorld().numberOfObjects() < 120)
        {
            if(energia > 5 && Nivel.probabilidad(4))
            {
                Gamma g = new Gamma();
                getWorld().addObject(g, getX()+25, getY()+25);
                energia -= 5;
            }
        }
        if(isTouching(Gamma.class))
                absorbeGamma(); 
    }

    /**
     * Incrementa la energía en qty unidades
     * @param qty
     */
    public void addEnergia(int qty)
    {
        energia += qty;
        energia = energia < 1 ? 1 : energia;
    }

    /**
     * Agrega qty electrones al átomo
     */
    public void addElectrones(int qty)
    {
        electrons += qty;
    }

    /**
     * Obtiene la cantidad de electrones que tiene el átomo
     */
    public int getElectrones()
    {
        return electrons;
    }

    /**
     * Agrega qty protones al átomo
     */
    public void addProtones(int qty)
    {
        protons += qty;
    }

    /**
     * Obtiene la cantidad de protones en el átomo
     */
    public int getProtones()
    {
        return protons;
    }

    /**
     * Agrega qty neutrones al átomo
     */
    public void addNeutrones(int qty)
    {
        neutrons += qty;
    }

    /**
     * Obtiene la cantidad de neutrones en el átomo
     */
    public int getNeutrones()
    {
        return neutrons;
    }

    /**
     * Absorbe un neutrón
     */
    public void absorbeNeutron()
    {
        removeTouching(Neutron.class);
        Nivel n = (Nivel) getWorld();
        n.generaNeutron();
        addNeutrones(3);
        actualizaTamanno();
    }

    /**
     * Absorbe un protón
     */
    public void absorbeProton()
    {
        removeTouching(Proton.class);
        Nivel n = (Nivel) getWorld();
        n.generaProton();
        addProtones(3);
        actualizaTamanno();
    }

    /**
     * Absorbe un electrón
     */
    public void absorbeElectron()
    {
        removeTouching(Electron.class);
        Nivel n = (Nivel) getWorld();
        n.generaElectron();
        addElectrones(3);
    }

    /**
     * Absorbe una partícula alfa
     */    
    public void absorbeAlfa()
    {
        // removeTouching(Alfa.class);
        addProtones(2);
        addNeutrones(2);
        actualizaTamanno();
    }

    /**
     * Emite una partícula alfa
     */
    public void emiteAlfa()
    {
        addProtones(-2);
        addNeutrones(-2);
        Nivel n = (Nivel) getWorld();
        n.generaElectron();
        actualizaTamanno();
    }
    
    /**
     * Absorbe radiación gamma
     */
    public void absorbeGamma()
    {
        int newP, newN, newE;
        int energ = ((Gamma)getOneIntersectingObject(Gamma.class)).getEnergia();
        removeTouching(Gamma.class);

        if(protons < 8 || neutrons < 8)
        {
            Nivel nv = (Nivel) getWorld();
            for (int i = 0; i < protons/3; i++) {
                Proton p = new Proton();
                nv.addObject(p, getX(), getY());
            }
            for (int i = 0; i < neutrons/3; i++) {
                Neutron n = new Neutron();
                nv.addObject(n, getX(), getY());
            }
            for (int i = 0; i < electrons/3; i++) {
                Electron e = new Electron();
                nv.addObject(e, getX(), getY());
            }
            getWorld().removeObject(this);
            return;
        }
        else{
            newP = protons / 2;
            newN = neutrons / 2;
            newE = electrons /2;
            protons -= newP;
            neutrons -= newN;
            electrons -= newE;
            actualizaTamanno();
            addEnergia(energ);

            Atomo newAtom = new Atomo(newE, newP, newN);
            getWorld().addObject(newAtom, getX()+5, getY()+5);
            
            if(Nivel.probabilidad(10))
            {
                Nivel n = (Nivel) getWorld();
                n.generaGamma();
            }
        }
        
    }
    
    /**
     * rebota en una dirección aleatoria
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
     * Rebota desde un borde del mundo
     */
    public void rebotaEdge()
    {
        turn(Greenfoot.getRandomNumber(180)+90);
        dir = getRotation();
        move(5);
    }
    
    /**
     * Actualiza el tamaño de la imagen del objeto según
     * la masa del átomo
     */
    public void actualizaTamanno()
    {
        int p = getProtones(), n = getNeutrones();
        int masa = p + n;

        int size = (int) Math.pow((double) masa, 0.65);
        size = size < 10 ? 10 : size;

        GreenfootImage img = new GreenfootImage("atom-bw.png");
        img.scale(size, size);
        setImage(img);
    }

}
