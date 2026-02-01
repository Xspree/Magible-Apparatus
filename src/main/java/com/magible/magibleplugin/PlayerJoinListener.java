package com.magible.magibleplugin;

import com.magible.ui.test.Test1Page;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class PlayerJoinListener {

    private static final Message MESSAGE_PORTALS_DEVICE_WORLD_IS_DEAD = Message.translation("server.portals.device.worldIsDead");
    public static void onPlayerJoin(PlayerReadyEvent event)
    {

        Ref<EntityStore> ref = event.getPlayerRef();
        PlayerRef playerRef = event.getPlayer().toHolder().getComponent(PlayerRef.getComponentType());
        World world = event.getPlayer().getWorld();
        Store<EntityStore> store = world.getEntityStore().getStore();
        Test1Page page = new Test1Page(playerRef);
        event.getPlayer().getPageManager().openCustomPage(ref,store,page);

        /*Holder<EntityStore> holder = event.getHolder();
        World world = event.getWorld();
        PlayerRef playerRef = holder.getComponent(PlayerRef.getComponentType());



        Store<EntityStore> store = world.getEntityStore().getStore();


        Player player = holder.getComponent(Player.getComponentType());


        UUIDComponent uuidComponent = holder.getComponent(UUIDComponent.getComponentType());

        assert uuidComponent != null;

        UUID playerUUID = uuidComponent.getUuid();

        Ref<EntityStore> ref = playerRef.getReference();
        if(ref != null)
        {
            Test1Page page = new Test1Page(playerRef);
            player.getPageManager().openCustomPage(ref, store,page);
        }*/


    }

}
