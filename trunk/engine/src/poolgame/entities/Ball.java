/*
CarGame, a game where you can drive with a car.
Copyright (C) 2010  Vortex GameStudio

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package poolgame.entities;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bounding.BoundingVolume;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.math.Vector3f;

import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
//import com.jme3.bullet.nodes.PhysicsNode;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.Camera;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.shape.Sphere.TextureMode;
import com.jme3.texture.Texture;

/**
 *
 * @author Vortex
 */
public class Ball extends Entity {
    private RigidBodyControl ball_phy;
    private SphereCollisionShape sphereCollisionShape;
    private Spatial ball_geo;
    private Material ball_mat;
    private Camera cam;

    public Ball(AssetManager assetManager, Node parent, PhysicsSpace physicsSpace, Camera cam, Vector3f startPos, int index) {
        super(assetManager, parent, physicsSpace);

        //com.jme3.terrain
        //BufferGeomap

        // Create Pool Ball !!!!!!!!!!!!!!!
        // Add a physics sphere to the world
      /** This method creates one individual physical cannon ball.
       * By defaul, the ball is accelerated and flies
       * from the camera position in the camera direction.*/
        /** Initialize the cannon ball geometry */
        this.cam = cam;
        
        ball_geo = getParent().getChild("ball_" + index);
        if(ball_geo != null)    {
            ball_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            TextureKey key2 = new TextureKey("Textures/ball_0/base.png");
            key2.setGenerateMips(true);
            Texture tex2 = assetManager.loadTexture(key2);
            ball_mat.setTexture("ColorMap", tex2);

            /** Set ball material and activate shadows */
            ball_geo.setMaterial(ball_mat);
            ball_geo.setShadowMode(ShadowMode.CastAndReceive);

            /** Make the ball physcial with a mass > 0.0f */
            BoundingVolume ball_vol = ball_geo.getWorldBound();
            float distance = ball_vol.getVolume();
            sphereCollisionShape = new SphereCollisionShape(0.1f);
            //sphereCollisionShape = new SphereCollisionShape(distance);
            ball_phy = new RigidBodyControl(sphereCollisionShape, 1f);

            /** Add physical ball to physics space. */
            ball_geo.addControl(ball_phy);
            getPhysicsSpace().add(ball_phy);
        }

    }
    
    public void shoot() {
        /** Accelerate the physcial ball to shoot it. */
        ball_phy.setLinearVelocity(cam.getDirection().mult(25));        
    }

}
