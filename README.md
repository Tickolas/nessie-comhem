# nessie-comhem
Ett Monty Hall-problem för Com Hem

# Kompilering
Ladda ner projektet och skriv följande i konsolen, stående i projektets rot:
mvn package

# Kör programmet
Ladda ner den färdiga JAR-filen, nessie-comhem-1.0.jar. Ställ dig i mappen med JAR-filen och skriv:
java -jar nessie-comhem-1.0.jar

Alternativt kan du ladda ner hela projektet för att sedan kompilera och köra det med Maven.

# Interagera med programmet
För att testa att programmet kör, gå in i din webbläsare och gå till denna adress: http://localhost:8080/nessie. Programmet kör nu 100 simuleringar av båda strategierna med tre sjöar. Du kan även prova följande adresser:

http://localhost:8080/nessie/switch - 100 simuleringar av byta-sjö-strategin med tre sjöar
http://localhost:8080/nessie/stay - 100 simuleringar av stanna-strategin med tre sjöar
http://localhost:8080/nessie/both - 100 simuleringar av båda strategier med tre sjöar
http://localhost:8080/nessie/both?simulations=500 - 500 simuleringar av båda strategier med tre sjöar
http://localhost:8080/nessie/both?simulations=500&numberOfLakes=4 - 500 simuleringar av båda strategier med fyra sjöar
http://localhost:8080/nessie/switch?numberOfLakes=4 - 100 simuleringar av byta-sjö-strategin med fyra sjöar

För mer avancerade interaktioner, använd en REST-klient, exempelvis POSTMAN för Chrome (https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop) 
