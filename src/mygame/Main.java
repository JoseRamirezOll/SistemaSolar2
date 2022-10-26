package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public Spatial movimientoTierra;
    public Spatial movimientoMercurio;
    public Spatial movimientoVenus;
    public Spatial movimientoMarte;
    public Spatial movimientoJupiter;
    public static final Quaternion PITCH090 =
            new Quaternion().fromAngleAxis(FastMath.PI, new Vector3f(1,0,0));
    
    Geometry geomSol; 
    Geometry geomTierra;
    Geometry geomLuna;
    Geometry goemMercurio;
    Geometry geomVenus;
    Geometry geomMarte;
    Geometry geomJupiter;
    public static void main(String[] args) {
       
        AppSettings settings = new AppSettings(true); // crear el objeto para controlar las configuraciones
        settings.setTitle("Sistema solar");
        
        // cargamos la imagen 
        settings.setSettingsDialogImage("Interface/juego.png");
        
        
        settings.setResolution(1280, 960);
        
        Main app = new Main();
        app.setSettings(settings);
        app.start();
    }// fin del main 

    @Override
    public void simpleInitApp() {
        // Box b = new Box(1, 1, 1);
        // creamos una esfera para el sol
        flyCam.setMoveSpeed(15f);
        Quaternion rotarSol =  new Quaternion(20,20,20,20);
        //cam.setLocation(new Vector3f(0,40,15));
        //cam.setRotation(PITCH090);
        // creamos las esferas que seran los planetas.
        
        Sphere esferaSol = new Sphere(50,50,5.0f);
        Sphere esferaLuna =  new Sphere(50, 50,.11f);
        Sphere esferaTierra =  new Sphere(40, 40,.5f);
        Sphere esferaMercurio = new Sphere(25,40,.5f);
        Sphere esferaVenus =  new Sphere(25,40,.5f);
        Sphere esferaMarte = new Sphere(25,40,.5f);
        Sphere esferaJupiter = new Sphere(25,40,2.5f);
        
        // creamos las geometrias de cada esfera 
        
        geomSol = new Geometry("Sol", esferaSol);
        geomTierra =  new Geometry("Tierra", esferaTierra);
        geomLuna = new Geometry("luna", esferaLuna);
        goemMercurio = new Geometry("Mercurio",esferaMercurio);
        geomVenus =  new Geometry("Venus", esferaVenus);
        geomMarte =  new Geometry("Marte",esferaMarte);
        geomJupiter = new Geometry("Jupiter",esferaJupiter);
        
        // crramos los materiales para cada una de las esferas y le asignamos sus geoetrias.
        // añadimos la textura la geometria del sol.
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setTexture("ColorMap", assetManager.loadTexture("Textures/sol.jpg"));
        geomSol.setMaterial(mat);
        geomSol.rotate(rotarSol);
        // añadimos la textura 
        Material matTierra =  new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matTierra.setTexture("ColorMap", assetManager.loadTexture("Textures/planeta_tierra.jpg"));
        geomTierra.setMaterial(matTierra);
        geomTierra.move(20, 0, 0);
        geomTierra.rotate(2,0,0);
        
        Material matLuna =  new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matLuna.setTexture("ColorMap", assetManager.loadTexture("Textures/luna.jpg"));
        geomLuna.setMaterial(matLuna);
        geomLuna.move(21,0, 0);
        
        Material matMercurio =  new Material(assetManager , "Common/MatDefs/Misc/Unshaded.j3md");
        matMercurio.setTexture("ColorMap", assetManager.loadTexture("Textures/mercurio_textura.jpg"));
        goemMercurio.setMaterial(matMercurio);
        goemMercurio.move(10,0,0);
        
        Material matVenus =  new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matVenus.setTexture("ColorMap",assetManager.loadTexture("Textures/textura_venus.jpg"));
        geomVenus.setMaterial(matVenus);
        geomVenus.move(15,0,0);
        
        Material matMarte = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        matMarte.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_marte.jpg"));
        geomMarte.setMaterial(matMarte);
        geomMarte.move(26,0,0);
        
        Material matJupiter = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        matJupiter.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_jupiter.jpg"));
        geomJupiter.setMaterial(matJupiter);
        geomJupiter.move(33,0,0);
        geomJupiter.rotate(5,0,0);
        // nodos de traslacion
        Node nodoSistemaSolar = new Node("Nodo_sol");
        
        Node nodoTraslacionTierra =  new Node("Nodo_tierra");
        
        Node nodoTraslacionMercurio = new Node("Nodo_mercurio");
        
        Node nodoTraslacionVenus = new Node("Nodo_venus");
        
        Node nodoTraslacionMarte = new Node("Nodo_marte");
        
        Node nodoTraslacionJupiter = new Node("Nodo_jupiter");
        
        
        // agregamos los planetas a sus respectivos nodos.
        
        nodoTraslacionTierra.attachChild(geomTierra);
        
        nodoTraslacionTierra.attachChild(geomLuna);
        
        nodoTraslacionVenus.attachChild(geomVenus);
        
        nodoTraslacionMarte.attachChild(geomMarte);
        
        nodoTraslacionJupiter.attachChild(geomJupiter);
        
        nodoSistemaSolar.attachChild(geomSol);
        
        nodoSistemaSolar.attachChild(nodoTraslacionTierra);
        
        nodoSistemaSolar.attachChild(nodoTraslacionMercurio);
        
        nodoSistemaSolar.attachChild(nodoTraslacionVenus);
        
        nodoSistemaSolar.attachChild(nodoTraslacionMarte);
        
        nodoSistemaSolar.attachChild(nodoTraslacionJupiter);
        
        nodoTraslacionMercurio.attachChild(goemMercurio);
        
        rootNode.attachChild(nodoSistemaSolar);
        
    }

    @Override
    public void simpleUpdate(float tpf) 
    {
        
        //TODO: add update code
        if(movimientoTierra == null && movimientoMercurio == null&& movimientoVenus == null&& movimientoVenus == null){
            movimientoTierra = rootNode.getChild("Nodo_tierra");
            movimientoMercurio = rootNode.getChild("Nodo_mercurio");
            movimientoVenus = rootNode.getChild("Nodo_venus");
            movimientoMarte = rootNode.getChild("Nodo_marte");
            movimientoJupiter = rootNode.getChild("Nodo_jupiter");
        }
        else{
          movimientoTierra.rotate(0, tpf, 0);
          geomTierra.rotate(0,tpf,0);
          movimientoMercurio.rotate(0,tpf-.001f,0);
          goemMercurio.rotate(0,tpf,0);
          movimientoVenus.rotate(0,tpf+.001f,0);
          geomVenus.rotate(0,tpf,0);
          movimientoMarte.rotate(0,tpf+0.002f,0);
          geomMarte.rotate(0,tpf,0);
          movimientoJupiter.rotate(0,tpf+0.003f,0);
          geomJupiter.rotate(0,tpf,0);
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}