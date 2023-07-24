package pro.sky.telegrambot.service;

/**
 * Service for command processing
 */
public interface CommandHandlerService {

    /**
     * Process the command
     *
     * @param chatID chat identification
     * @param command text for command
     * @return response to command
     */
    String handleCommand(Long chatID, String command);
}
