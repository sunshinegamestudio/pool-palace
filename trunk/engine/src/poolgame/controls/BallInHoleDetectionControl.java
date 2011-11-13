/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package poolgame.controls;

import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.MeshCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.control.Control;

/**
 *
 * @author Vortex
 * Detect if the ball collides with the bottom plate of the hole.
 */

public class BallInHoleDetectionControl extends RigidBodyControl implements PhysicsTickListener, PhysicsCollisionListener   {
    
    private BoxCollisionShape boxCollisionShape;
    
    public void BallInHoleDetectionControl(Mesh hole)   {
        boxCollisionShape = new BoxCollisionShape(new Vector3f(1, 1, 1));
        
        super.setMass(0);
        super.setCollisionShape(boxCollisionShape);
        getPhysicsSpace().addTickListener(this);
        getPhysicsSpace().addCollisionListener(this);
    }
    public void prePhysicsTick(PhysicsSpace space, float f){
      // apply state changes ...
    }

    public void physicsTick(PhysicsSpace space, float f){
      // poll game state ...
    }

    public void collision(PhysicsCollisionEvent event) {
        if ("Box".equals(event.getNodeA().getName()) || "Box".equals(event.getNodeB().getName())) {
            if ("bullet".equals(event.getNodeA().getName()) || "bullet".equals(event.getNodeB().getName())) {
                //fpsText.setText("You hit the box!");
            }
        }
    }
}
