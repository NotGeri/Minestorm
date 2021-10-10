package net.minestorm.server.command.builder.parser;

import net.minestorm.server.command.builder.CommandSyntax;
import net.minestorm.server.command.builder.exception.ArgumentSyntaxException;

/**
 * Holds the data of an invalidated syntax.
 */
public class CommandSuggestionHolder {
    public CommandSyntax syntax;
    public ArgumentSyntaxException argumentSyntaxException;
    public int argIndex;
}
