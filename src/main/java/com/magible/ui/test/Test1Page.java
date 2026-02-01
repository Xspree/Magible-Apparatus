package com.magible.ui.test;

import com.hypixel.hytale.builtin.model.commands.ModelCommand;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.protocol.packets.interface_.CustomUIEventBindingType;
import com.hypixel.hytale.protocol.packets.interface_.Page;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.pages.InteractiveCustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.EventData;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class Test1Page extends InteractiveCustomUIPage {
    public Test1Page(@Nonnull PlayerRef playerRef) {
        super(playerRef, CustomPageLifetime.CanDismissOrCloseThroughInteraction,
                Test1PageEventData.CODEC);
    }

    @Override
    public void handleDataEvent(@Nonnull Ref ref,
                                @Nonnull Store store,
                                @Nonnull Object data) {
        Player player = (Player) store.getComponent(ref, Player.getComponentType());

        playerRef.sendMessage(Message.raw("Button Pressed! Closing page"));

        player.getPageManager().setPage(ref,store, Page.None);

        //player.getWorld().execute();

        playerRef.sendMessage(Message.raw("/model set PlayerGnome"));

        ModelCommand model = new ModelCommand();



    }

    @Override
    public void build(@NotNull Ref<EntityStore> var1,
                      @NotNull UICommandBuilder var2,
                      @NotNull UIEventBuilder var3,
                      @NotNull Store<EntityStore> var4)
    {
        var2.append("Pages/Test1Page.ui");

        var3.addEventBinding(CustomUIEventBindingType.Activating,"#Button",
                EventData.of("Action","Test1"));
    }

    public static class Test1PageEventData {
        static final String KEY_ACTION = "Action";
        static final String ACTION_RESPAWN = "Test1";
        public static final BuilderCodec<Test1Page.Test1PageEventData> CODEC = BuilderCodec.builder(
                        Test1Page.Test1PageEventData.class, Test1Page.Test1PageEventData::new
                )
                .addField(new KeyedCodec<>("Action", Codec.STRING), (entry, s) -> entry.action = s, entry -> entry.action)
                .build();
        private String action;
    }
}
