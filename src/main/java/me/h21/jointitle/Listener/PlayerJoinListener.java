package me.h21.jointitle.Listener;

import me.h21.jointitle.Config.Config;
import me.h21.jointitle.JoinTitle;
import me.rojo8399.placeholderapi.PlaceholderService;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedPermissionData;
import net.luckperms.api.context.ContextManager;
import net.luckperms.api.context.ImmutableContextSet;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.query.QueryOptions;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.text.title.Title;

import java.util.UUID;

public class PlayerJoinListener {

    LuckPerms api = LuckPermsProvider.get();

    public boolean hasPermission(User user, String permission) {
        ContextManager contextManager = api.getContextManager();
        ImmutableContextSet contextSet = contextManager.getContext(user).orElseGet(contextManager::getStaticContext);

        CachedPermissionData permissionData = user.getCachedData().getPermissionData(QueryOptions.contextual(contextSet));
        return permissionData.checkPermission(permission).asBoolean();
    }

    @Listener
    public void playerJoinEvent(ClientConnectionEvent.Join e) {

        /**LuckPerms Utils**/

        Node node = Node.builder("*").build();

        /**PlaceholderAPI Utils**/

        PlaceholderService phservice = JoinTitle.getInstance().getPlaceHolder();

        /**Misc Utils**/

        UUID id = e.getTargetEntity().getUniqueId();
        Player player = e.getTargetEntity();

        CommentedConfigurationNode config = Config.getConfig();

        if (hasPermission(api.getUserManager().getUser(id), "jointitle.title.default")) { //perm check

            e.getTargetEntity().sendTitle(Title.builder()
                    .title(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getDefaultSampel(), "#title:", "#")), player, null))
                    .subtitle(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getDefaultSampel(), "#subtitle:", "#")), player, null))
                    .actionBar(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getDefaultSampel(), "#actionbar:", "#")), player, null))
                    .stay(config.getNode("Default").getNode("Staytime").getInt())
                    .fadeIn(config.getNode("Default").getNode("FadeIn").getInt())
                    .fadeOut(config.getNode("Default").getNode("FadeOut").getInt())
                    .build());

        }

        if (hasPermission(api.getUserManager().getUser(id), "jointitle.title.vip")) { //perm check

            e.getTargetEntity().sendTitle(Title.builder()
                    .title(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getVipSampel(), "#title:", "#")), player, null))
                    .subtitle(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getVipSampel(), "#subtitle:", "#")), player, null))
                    .actionBar(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getVipSampel(), "#actionbar:", "#")), player, null))
                    .stay(config.getNode("Vip").getNode("Staytime").getInt())
                    .fadeIn(config.getNode("Vip").getNode("FadeIn").getInt())
                    .fadeOut(config.getNode("Vip").getNode("FadeOut").getInt())
                    .build());

        }

        if (hasPermission(api.getUserManager().getUser(id), "jointitle.title.admin")) { //perm check

            e.getTargetEntity().sendTitle(Title.builder()
                    .title(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getAdminSampel(), "#title:", "#")), player, null))
                    .subtitle(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getAdminSampel(), "#subtitle:", "#")), player, null))
                    .actionBar(phservice.replacePlaceholders(TextSerializers.FORMATTING_CODE.deserialize(StringUtils.substringBetween(Config.getAdminSampel(), "#actionbar:", "#")), player, null))
                    .stay(config.getNode("Admin").getNode("Staytime").getInt())
                    .fadeIn(config.getNode("Admin").getNode("FadeIn").getInt())
                    .fadeOut(config.getNode("Admin").getNode("FadeOut").getInt())
                    .build());

        }

    }

}

