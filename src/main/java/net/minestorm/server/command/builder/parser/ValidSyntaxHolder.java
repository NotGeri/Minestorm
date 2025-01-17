package net.minestorm.server.command.builder.parser;

import net.minestorm.server.command.builder.CommandSyntax;
import net.minestorm.server.command.builder.arguments.Argument;

import java.util.Map;

/**
 * Holds the data of a validated syntax.
 */
public class ValidSyntaxHolder {
    public String commandString;
    public CommandSyntax syntax;
    public Map<Argument<?>, ArgumentParser.ArgumentResult> argumentResults;

}
