Problemlösning historia

1a problemet.
api-nykeln som bifogades i uppgiften. Hade tyvärr gått ut.
Så skapade en ny nyckel med mina egna personuppgifter.
Hade således en nyckel som tillät 500 requests / månad.

2a problemet.
SLs api, https://api.sl.se/api2/LineData.xml?model=site
Tycks inte tillåta att man kombinerar (filtrerar) sökdata. Hakade jag på ett busslinje-nummer så fick jag
ändån ut en -gigantisk- lista på allt mellan himmel och jord.
Så jag lyckades inte lista ut hur jag skulle söka alla hållplatser baserat på bussar.

Därför blev det hela nu en flerstegsraket med lite obekvämt stora datamängder.

1: Hämta alla busslinjer som finns.
2: Hämta alla hållplatser som finns, eller JourneyPatternPointOnLine i Trafiklabs termer.
Denna innehåller alla hållplatser som trafikeras av -någon- linje. Men ej namn. Bara JourneyPatternPointNumber (id för stoppställe)

3: För varje busslinje, räkna antal stopp
4: Sortera denna lista.
5: Skriv ut denna lista

6: För busslinjen med flest stopp, hämta en lista på alla hållplatser där id för stoppstället kan matchas mot StopPointName som är
namnet i klartext.

