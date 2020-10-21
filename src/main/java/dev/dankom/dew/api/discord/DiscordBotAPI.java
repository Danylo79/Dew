package dev.dankom.dew.api.discord;

import dev.dankom.dew.config.Private;
import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import dev.dankom.dew.main.MainClass;
import dev.dankom.dew.main.MainClassType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordBotAPI extends MainClass {
    private String token;
    private JDA jda;

    public DiscordBotAPI(String name) throws LoginException {
        super(MainClassType.JDA);
        this.token = Private.getInstance().getConfig().get("jdaToken").toString();

        JDABuilder builder = JDABuilder.createDefault(token);

        jda = builder.build();

        Logger.log(LogLevel.INFO, "Activated bot " + jda.getToken() + " (" + name + ")");
    }

    public JDA getJDA() {
        return jda;
    }
}
