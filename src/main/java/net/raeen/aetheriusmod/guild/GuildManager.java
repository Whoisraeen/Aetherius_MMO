package net.raeen.aetheriusmod.guild;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuildManager {
    private final Map<UUID, Guild> guilds = new HashMap<>();

    public Guild createGuild(UUID leaderId, String name) {
        UUID guildId = UUID.randomUUID();
        Guild guild = new Guild(guildId, name);
        guild.addMember(leaderId, "Leader");
        guilds.put(guildId, guild);
        return guild;
    }

    public Guild getGuild(UUID guildId) {
        return guilds.get(guildId);
    }

    public Guild getGuildByPlayer(UUID playerId) {
        return guilds.values().stream()
                .filter(guild -> guild.getMembers().containsKey(playerId))
                .findFirst()
                .orElse(null);
    }

    public void disbandGuild(UUID guildId) {
        guilds.remove(guildId);
    }
}
