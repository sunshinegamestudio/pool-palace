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
import com.jme3.bullet.PhysicsSpace;
import com.jme3.math.Vector3f;

import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
//import com.jme3.bullet.nodes.PhysicsNode;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Vortex
 */
public class Ball extends Entity {
    public Ball(AssetManager assetManager, Node parent, PhysicsSpace physicsSpace) {
        super(assetManager, parent, physicsSpace);

        //com.jme3.terrain
        //BufferGeomap

        // Create Pool Ball !!!!!!!!!!!!!!!
        // Add a physics sphere to the world
      /** This method creates one individual physical cannon ball.
       * By defaul, the ball is accelerated and flies
       * from the camera position in the camera direction.*/
        /** Create a pool ball geometry and attach to scene graph. */
        Geometry ball_geo = new Geometry("pool ball", sphere);
        ball_geo.setMaterial(stone_mat);
        rootNode.attachChild(ball_geo);
        /** Position the cannon ball and activate shadows */
        ball_geo.setLocalTranslation(cam.getLocation());
        ball_geo.setShadowMode(ShadowMode.CastAndReceive);
        /** Make the ball physcial with a mass > 0.0f */
        ball_phy = new RigidBodyControl(1f);
        /** Add physical ball to physics space. */
        ball_geo.addControl(ball_phy);
        bulletAppState.getPhysicsSpace().add(ball_phy);
        /** Accelerate the physcial ball to shoot it. */
        ball_phy.setLinearVelocity(cam.getDirection().mult(25));        
        
        //Node physicsSphere = PhysicsTestHelper.createPhysicsTestNode(assetManager, new SphereCollisionShape(1), 1);
        //physicsSphere.getControl(RigidBodyControl.class).setPhysicsLocation(new Vector3f(3, 6, 0));

        getParent().attachChild(physicsSphere);
        getPhysicsSpace().add(physicsSphere);
    }

}