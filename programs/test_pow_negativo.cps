real r = 2 ^ -2;
if (r != 0.25):
    throw "2 ^ -2 deve valere 0.25";
end

// La potenza ha sempre tipo real: anche 2 ^ 3 non deve causare divisione intera.
real rapporto = (2 ^ 3) / 3;
if (rapporto < 2.66):
    throw "la potenza deve mantenere il tipo real nelle espressioni composte";
end

try:
    real impossibile = 0 ^ -1;
    throw "0 ^ -1 doveva produrre un errore";
catch (errore):
    if (errore != "divisione per zero (base zero con esponente negativo)"):
        throw errore;
    end
end

print "potenza con esponente negativo: OK";
