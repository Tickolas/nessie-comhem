# nessie-comhem
Ett Monty Hall-problem för Com Hem

# Kör programmet
Ladda ner den färdiga JAR-filen, nessie-comhem-1.0.jar. Ställ dig i mappen med JAR-filen och skriv:
java -jar nessie-comhem-1.0.jar

# Interagera med programmet
För att testa att programmet kör, gå till denna adress [http://localhost:8080/nessie](http://localhost:8080/nessie) . Programmet kör nu 100 simuleringar av båda strategierna med tre sjöar och visar resultatet. Du kan även prova följande adresser:

[http://localhost:8080/nessie/switch](http://localhost:8080/nessie/switch) - 100 simuleringar av byta-sjö-strategin med tre sjöar

[http://localhost:8080/nessie/stay](http://localhost:8080/nessie/stay) - 100 simuleringar av stanna-strategin med tre sjöar

[http://localhost:8080/nessie/both](http://localhost:8080/nessie/both) - 100 simuleringar av båda strategier med tre sjöar

[http://localhost:8080/nessie/both?simulations=500](http://localhost:8080/nessie/both?simulations=500) - 500 simuleringar av båda strategier med tre sjöar

[http://localhost:8080/nessie/both?simulations=500&numberOfLakes=4](http://localhost:8080/nessie/both?simulations=500&numberOfLakes=4) - 500 simuleringar av båda strategier med fyra sjöar

[http://localhost:8080/nessie/switch?numberOfLakes=4](http://localhost:8080/nessie/switch?numberOfLakes=4) - 100 simuleringar av byta-sjö-strategin med fyra sjöar

För mer avancerade interaktioner, använd en REST-klient, exempelvis [POSTMAN för Chrome](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop) 

# Kompilering
Ladda ner hela projektet och skriv följande i konsolen, stående i projektets rot:
mvn package

Kör sedan programmet genom att skriva:
mvn spring-boot:run

Kör tester genom att skriva:
mvn verify
