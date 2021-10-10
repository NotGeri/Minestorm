package net.minestorm.server.particle;

import net.minestorm.server.registry.ProtocolObject;
import net.minestorm.server.utils.NamespaceID;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

@ApiStatus.NonExtendable
public interface Particle extends ProtocolObject, Particles {

    static @NotNull Collection<@NotNull Particle> values() {
        return ParticleImpl.values();
    }

    static @Nullable Particle fromNamespaceId(@NotNull String namespaceID) {
        return ParticleImpl.getSafe(namespaceID);
    }

    static @Nullable Particle fromNamespaceId(@NotNull NamespaceID namespaceID) {
        return fromNamespaceId(namespaceID.asString());
    }

    static @Nullable Particle fromId(int id) {
        return ParticleImpl.getId(id);
    }
}
