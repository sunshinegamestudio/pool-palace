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
import com.jme3.bullet.PhysicsSpace;
import com.jme3.math.Vector3f;

import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
//import com.jme3.bullet.nodes.PhysicsNode;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.shape.Sphere.TextureMode;
import com.jme3.texture.Texture;

import java.util.List;
import poolgame.controls.*;

/**
 *
 * @author Vortex
 */
public class Hole extends Entity {
    private Spatial hole_geo;
    private BallInHoleDetectionControl ballInHoleDetectionControl;

    public Hole(AssetManager assetManager, Node parent, PhysicsSpace physicsSpace, int index) {
        super(assetManager, parent, physicsSpace);

        ballInHoleDetectionControl = new BallInHoleDetectionControl();
        
        hole_geo = getParent().getChild("hole_" + index + "1-ogremesh");
        if(hole_geo != null)    {
            hole_geo.addControl(ballInHoleDetectionControl);
        }
    }

}
