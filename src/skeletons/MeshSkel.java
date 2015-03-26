/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skeletons;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;

/**
 *
 * @author Tor Arne using IFE Examples
 */
public class MeshSkel extends SimpleApplication {
    
   public static void main(String[] args) {
        MeshSkel app = new MeshSkel();
        app.start();
    }
    
    @Override
    public void simpleInitApp() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Mesh myHouse = oneHouse(true);
        
        Geometry houseGeom = new Geometry("House",myHouse);
        
        Material mat = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        //mat.setColor("Color", ColorRGBA.Yellow);
        mat.setBoolean("VertexColor", true);
        
        houseGeom.setMaterial(mat);
        
        rootNode.attachChild(houseGeom);
                
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
 
    public Mesh oneHouse(boolean indexed) {
    
        Vector3f[] triangleMesh = null;
        int[] indices = null;
        
        // Not indexed
        if (!indexed) {
            // A House built with Three Triangles
            triangleMesh = new Vector3f[] {
                // Lower left part body of house
                new Vector3f(0,0,0),
                new Vector3f(1,0,0),
                new Vector3f(0,1,0),
                
                // Roof of house
                new Vector3f(1,1,0),
                new Vector3f(0.5f,1.5f,0),
                new Vector3f(0,1,0),
                
                // Upper right part of house
                new Vector3f(1,0,0),
                new Vector3f(1,1,0),
                new Vector3f(0,1,0)
            };
        }
        
        // Indexed
        if (indexed) {
            // A House built with Three Triangles
            triangleMesh = new Vector3f[] {
                // House
                new Vector3f(0,0,0),
                new Vector3f(1,0,0),
                new Vector3f(0,1,0),
                // Roof
                new Vector3f(0.5f,1.5f,0),
                new Vector3f(1,1,0),
            };
            
            // Each number corresponds to a vertice number in the same order 
            // as they were created in the above triangleMesh
            indices = new int[] {
              // Lower Left
              2, 0, 1,
              // Upper Right
              1, 4, 2,
              // Roof
              2, 4, 3
            };
        }

        // Empty mesh object.
        Mesh houseMesh = new Mesh();

        // Assign buffers.
        houseMesh.setBuffer(VertexBuffer.Type.Position, 3,
                BufferUtils.createFloatBuffer(triangleMesh));
        
         // Per vertex coloring. RGBA.
        float[] colors = new float[]{
                1, 0, 0, 1,
                0, 1, 0, 1,
                0, 0, 1, 1,
                1, 1, 0, 1,
                0, 0, 1, 1,
                1, 1, 0, 1,
                0, 0, 1, 1,
                1, 1, 0, 1,
                0, 0, 1, 1
        };
        
        // More one-colored
        float[] colors2 = new float[]{
                0.5f, 0, 0, 1,
                0.5f, 0, 0, 1,
                1, 0, 0, 1,
                1, 0, 0, 1,
                0, 0, 1, 1,
                1, 0, 0, 1,
                1, 0, 0, 1,
                0.5f, 0, 0, 1,
                0.5f, 0, 0, 1
        };
        
        float[] colors3 = new float[]{
                1, 0, 0, 1,
                0, 1, 0, 1,
                0, 0, 1, 1
        };
        
        if (indexed && indices!=null) {
            houseMesh.setBuffer(VertexBuffer.Type.Index, 3,
                    BufferUtils.createIntBuffer(indices));
            
            houseMesh.setBuffer(VertexBuffer.Type.Color, 4,
                BufferUtils.createFloatBuffer(colors3));
        }
        
        if (!indexed) {
        houseMesh.setBuffer(VertexBuffer.Type.Color, 4,
                BufferUtils.createFloatBuffer(colors2));
        }       

        // Update the bounds of the mesh, so that bounding box is correctly
        // recalcualted internally by jME.
        houseMesh.updateBound();
            
        return houseMesh;
        //}
        //return null;
    }
    
    public Mesh oneHouse3D() {
    
        Vector3f[] triangleMesh = null;
        int[] indices = null;     
        
            // A House built with Three Triangles
            triangleMesh = new Vector3f[] {
                // House
                new Vector3f(0,0,0),
                new Vector3f(1,0,0),
                new Vector3f(0,1,0),
                // Roof
                new Vector3f(0.5f,1.5f,0),
                new Vector3f(1,1,0),
                // Z Direction, doing everything backwards, Z being -1
                new Vector3f(1,1,-1),
                new Vector3f(0.5f,1.5f,-1),
                new Vector3f(0,1,-1),
                new Vector3f(0,0,-1),
                new Vector3f(1,0,-1)
            };
            
            // Each number corresponds to a vertice number in the same order 
            // as they were created in the above triangleMesh
            indices = new int[] {
              // Lower Left
              2, 0, 1,
              // Upper Right
              1, 4, 2,
              // Roof
              2, 4, 3,
              // Sides
              
            };
        

        // Empty mesh object.
        Mesh houseMesh = new Mesh();

        // Assign buffers.
        houseMesh.setBuffer(VertexBuffer.Type.Position, 3,
                BufferUtils.createFloatBuffer(triangleMesh));
        
         // Per vertex coloring. RGBA.
        float[] colors = new float[]{
                1, 0, 0, 1,
                0, 1, 0, 1,
                0, 0, 1, 1,
                1, 1, 0, 1,
                0, 0, 1, 1,
                1, 1, 0, 1,
                0, 0, 1, 1,
                1, 1, 0, 1,
                0, 0, 1, 1
        };
        
        // More one-colored
        float[] colors2 = new float[]{
                0.5f, 0, 0, 1,
                0.5f, 0, 0, 1,
                1, 0, 0, 1,
                1, 0, 0, 1,
                0, 0, 1, 1,
                1, 0, 0, 1,
                1, 0, 0, 1,
                0.5f, 0, 0, 1,
                0.5f, 0, 0, 1
        };
        
        float[] colors3 = new float[]{
                1, 0, 0, 1,
                0, 1, 0, 1,
                0, 0, 1, 1
        };
        
        if (indexed && indices!=null) {
            houseMesh.setBuffer(VertexBuffer.Type.Index, 3,
                    BufferUtils.createIntBuffer(indices));
            
            houseMesh.setBuffer(VertexBuffer.Type.Color, 4,
                BufferUtils.createFloatBuffer(colors3));
        }
        
        if (!indexed) {
        houseMesh.setBuffer(VertexBuffer.Type.Color, 4,
                BufferUtils.createFloatBuffer(colors2));
        }       

        // Update the bounds of the mesh, so that bounding box is correctly
        // recalcualted internally by jME.
        houseMesh.updateBound();
            
        return houseMesh;
        //}
        //return null;
    }
    
}