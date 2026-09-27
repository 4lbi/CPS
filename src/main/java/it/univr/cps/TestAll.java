package it.univr.cps;

import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.util.Arrays;

/** Runner manuale degli smoke test presenti in {@code programs/}. */
public final class TestAll {

    private TestAll() { }

    public static void main(String[] args) {
        File dir = new File("programs");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".cps"));

        if (files == null || files.length == 0) {
            System.err.println("Nessun file .cps trovato nella cartella programs!");
            System.exit(1);
        }

        // Ordina alfabeticamente i file di test
        Arrays.sort(files);

        System.out.println("==================================================");
        System.out.println("   AVVIO ESECUZIONE AUTOMATICA DI TUTTI I TEST    ");
        System.out.println("==================================================\n");

        int superati = 0;
        int falliti = 0;

        for (File file : files) {
            System.out.println("--------------------------------------------------");
            System.out.println(">> Esecuzione: " + file.getName());
            System.out.println("--------------------------------------------------");

            try {
                MainCPS.execute(CharStreams.fromPath(file.toPath()));

                System.out.println("\n[OK] " + file.getName() + " completato con successo.\n");
                superati++;

            } catch (Exception exception) {
                System.out.println("\n[ERRORE]: " + exception.getClass().getSimpleName()
                        + " - " + exception.getMessage() + "\n");
                falliti++;
            }
        }

        System.out.println("==================================================");
        System.out.println("               RIASSUNTO DEI TEST                 ");
        System.out.println("==================================================");
        System.out.println("Totale programmi: " + files.length);
        System.out.println("Superati:         " + superati);
        System.out.println("Falliti:          " + falliti);
        System.out.println("==================================================");

        if (falliti > 0)
            System.exit(1);
    }
}
