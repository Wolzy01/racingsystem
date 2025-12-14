package by.piatnitski.racing.service.command;

import java.util.HashMap;
import java.util.Map;
import by.piatnitski.racing.service.observer.ResultPublisher;

public class CommandFactory {
    private static final CommandFactory instance = new CommandFactory();
    private final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {
        // Инициализация зависимостей, которые нужны командам
        ResultPublisher publisher = new ResultPublisher();

        // Регистрируем команды по ключу "command"
        commands.put("login", new LoginCommand());
        commands.put("placeBet", new PlaceBetCommand());
        commands.put("listRaces", new ListRacesCommand());
        commands.put("fixResult", new FixResultCommand(publisher));
        commands.put("default", new DefaultCommand());
        commands.put("myBets", new MyBetsCommand());
        // Добавь остальные команды по аналогии
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(String name) {
        return commands.getOrDefault(name, new DefaultCommand());
    }
}
