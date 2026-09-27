try:
catch (errore):
    throw "un catch non deve essere eseguito senza errori";
end

try:
    throw "errore atteso";
catch (errore):
end

print "blocchi try/catch vuoti: OK";
