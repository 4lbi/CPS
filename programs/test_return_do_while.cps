function restituisci() -> int:
    do:
        return 42;
    while (false);
end

if (restituisci() != 42):
    throw "return nel do/while non riconosciuto";
end

print "return nel do/while: OK";
