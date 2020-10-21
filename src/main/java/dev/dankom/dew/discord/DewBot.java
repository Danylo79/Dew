package dev.dankom.dew.discord;

import dev.dankom.dew.api.discord.DiscordBotAPI;

import javax.security.auth.login.LoginException;

public class DewBot extends DiscordBotAPI {
    public DewBot() throws LoginException {
        super("DewBot");
    }
}
