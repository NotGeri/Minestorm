package net.minestorm.server.command.builder.parser;

import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.command.builder.CommandSyntax;
import net.minestorm.server.command.builder.arguments.Argument;

public class ArgumentQueryResult {
    public CommandSyntax syntax;
    public Argument<?> argument;
    public CommandContext context;
    public String input;
}
