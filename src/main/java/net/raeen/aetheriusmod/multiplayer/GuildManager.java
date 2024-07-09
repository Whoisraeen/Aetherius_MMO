package net.raeen.aetheriusmod.multiplayer;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuildManager {
    private final Map<UUID, Guild> guilds = new HashMap<>();

    public void createGuild(ServerPlayer leader, String name) {
        Guild guild = new Guild(leader.getUUID(), name);
        guilds.put(guild.getGuildId(), guild);
    }

    public void addMemberToGuild(UUID guildId, ServerPlayer newMember) {
        Guild guild = guilds.get(guildId);
        if (guild != null) {
            guild.addMember(newMember.getUUID());
        }
    }

    public void removeMemberFromGuild(UUID guildId, ServerPlayer member) {
        Guild guild = guilds.get(guildId);
        if (guild != null) {
            guild.removeMember(member.getUUID());
        }
    }

    public Guild getGuild(UUID guildId) {
        return guilds.get(guildId);
    }

    public void disbandGuild(UUID guildId) {
        guilds.remove(guildId);
    }
}
