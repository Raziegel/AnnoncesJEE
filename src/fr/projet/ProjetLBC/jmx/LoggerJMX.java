package fr.projet.ProjetLBC.jmx;


import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class LoggerJMX  implements  LoggerJMXMBean{

    String currentLevel;
    LoggerConfig loggerConfig;
    Configuration config;
    LoggerContext ctx;

    public LoggerJMX() {

        ctx = (LoggerContext) LogManager.getContext(false);
        config = ctx.getConfiguration();
        loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        currentLevel = loggerConfig.getLevel().toString();
    }

    @Override
    public String getLogLevel() {
        currentLevel = loggerConfig.getLevel().toString();
        return currentLevel;
    }

    @Override
    public void setLogLevel(String level) {
        Level lvl = Level.getLevel("");
        switch (level){
            case "DEBUG":
                lvl = Level.getLevel("DEBUG");
                loggerConfig.setLevel(lvl);
                break;
            case "debug":
                lvl = Level.getLevel("DEBUG");
                loggerConfig.setLevel(lvl);
                break;
            case "WARNING":
                lvl = Level.getLevel("WARN");
                loggerConfig.setLevel(lvl);
                break;
            case "warning":
                lvl = Level.getLevel("WARN");
                loggerConfig.setLevel(lvl);
                break;
            case "INFO":
                lvl = Level.getLevel("INFO");
                loggerConfig.setLevel(lvl);
                break;
            case "info":
                lvl = Level.getLevel("INFO");
                loggerConfig.setLevel(lvl);
                break;
            case "ERROR":
                lvl = Level.getLevel("ERROR");
                loggerConfig.setLevel(lvl);
                break;
            case "error":
                lvl = Level.getLevel("ERROR");
                loggerConfig.setLevel(lvl);
                break;
             default:
                 break;
        }
        ctx.updateLoggers();
    }
}
