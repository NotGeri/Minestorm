package testextension;

import net.minestorm.server.extensions.Extension;

public class TestExtension extends Extension {
    @Override
    public void initialize() {
        System.out.println("Hello from extension!");
    }

    @Override
    public void terminate() {

    }
}
