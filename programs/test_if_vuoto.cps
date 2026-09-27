int x = 10;
if (x > 0):
else:
    throw "eseguito else con condizione vera";
end

if (x < 0):
else:
    x = 20;
end

if (x < 0):
    throw "eseguito if con condizione falsa";
else if (x == 20):
else:
    throw "eseguito else dopo un else-if vero";
end

print "rami if vuoti: OK";
