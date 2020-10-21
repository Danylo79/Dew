package dev.dankom.dew.discord;

import dev.dankom.dew.api.discord.DiscordBotAPI;
import dev.dankom.dew.api.discord.listener.Listener;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class DewBot extends DiscordBotAPI {
    public DewBot() throws LoginException {
        super("DewBot");

        getJDA().addEventListener(new DewBotListener());
    }

    class DewBotListener extends Listener {
        @Override
        public void onMessageReceived(@NotNull MessageReceivedEvent event) {
            if (!event.getMessage().getAuthor().isBot()) {
                event.getChannel().sendMessage("Yoink").queue();
            }
        }
    }
}
