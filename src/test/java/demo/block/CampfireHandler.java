package demo.block;

import net.minestorm.server.instance.block.BlockHandler;
import net.minestorm.server.item.ItemStack;
import net.minestorm.server.item.Material;
import net.minestorm.server.tag.Tag;
import net.minestorm.server.tag.TagReadable;
import net.minestorm.server.tag.TagSerializer;
import net.minestorm.server.tag.TagWritable;
import net.minestorm.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.NBTList;
import org.jglrxavpok.hephaistos.nbt.NBTTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CampfireHandler implements BlockHandler {

    public static final Tag<List<ItemStack>> ITEMS = Tag.View(new TagSerializer<>() {
        private final Tag<NBTList<NBTCompound>> internal = Tag.NBT("Items");

        @Override
        public @Nullable List<ItemStack> read(@NotNull TagReadable reader) {
            NBTList<NBTCompound> item = reader.getTag(internal);
            if (item == null)
                return null;
            List<ItemStack> result = new ArrayList<>();
            item.forEach(nbtCompound -> {
                int amount = nbtCompound.getAsByte("Count");
                String id = nbtCompound.getString("id");
                Material material = Material.fromNamespaceId(id);
                result.add(ItemStack.of(material, amount));
            });
            return result;
        }

        @Override
        public void write(@NotNull TagWritable writer, @Nullable List<ItemStack> value) {
            if (value == null) {
                writer.removeTag(internal);
                return;
            }
            NBTList<NBTCompound> items = new NBTList<>(NBTTypes.TAG_Compound);
            for (var item : value) {
                NBTCompound compound = new NBTCompound()
                        .setByte("Count", (byte) item.getAmount())
                        .setByte("Slot", (byte) 1)
                        .setString("id", item.getMaterial().name());
                items.add(compound);
            }
            writer.setTag(internal, items);
        }
    });

    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return List.of(ITEMS);
    }

    @Override
    public @NotNull NamespaceID getNamespaceId() {
        return NamespaceID.from("minestom:test");
    }
}
