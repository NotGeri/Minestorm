package net.minestorm.server.world;

import net.minestorm.server.MinecraftServer;

/**
 * Those are all the difficulties which can be displayed in the player menu.
 * <p>
 * Sets with {@link MinecraftServer#setDifficulty(Difficulty)}.
 */
public enum Difficulty {

    PEACEFUL((byte) 0), EASY((byte) 1), NORMAL((byte) 2), HARD((byte) 3);

    private final byte id;

    Difficulty(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }
}
