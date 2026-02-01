package com.xcrossed.xcrossedplugin;

import com.xcrossed.ui.test.Test1Page;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class Test1Command extends AbstractPlayerCommand {

    public Test1Command(){ super("test1","Opens test 1 - static", false);}

    @Override
    protected void execute(CommandContext var1,
                           Store<EntityStore> var2,
                            Ref<EntityStore> var3,
                            PlayerRef var4,
                           World var5) {
        Player player = var2.getComponent(var3, Player.getComponentType());

        Test1Page page = new Test1Page(var4);

        player.getPageManager().openCustomPage(var3,var2,page);

    }
}
