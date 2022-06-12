package jade;

import components.SpriteRenderer;
import org.joml.Vector2f;
import org.joml.Vector4f;
import util.AssetPool;

public class LevelEditorScene extends Scene {

    public LevelEditorScene() {

    }

    @Override
    public void init() {
        this.camera = new Camera(new Vector2f(-250, 0));

        GameObject gameObject1 = new GameObject("Object 1", new Transform(new Vector2f(100, 100), new Vector2f(256, 256)));
        gameObject1.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/images/testImage1.png")));
        this.addGameObjectToScene(gameObject1);

        GameObject gameObject2 = new GameObject("Object 2", new Transform(new Vector2f(400, 400), new Vector2f(256, 256)));
        gameObject2.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/images/testImage2.png")));
        this.addGameObjectToScene(gameObject2);

        loadResources();
    }

    private void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
    }

    @Override
    public void update(float dt) {
        for (GameObject gameObject : this.gameObjects) {
            gameObject.update(dt);
        }

        this.renderer.render();
    }
}
