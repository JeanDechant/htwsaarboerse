# htwsaarboerse
HTW Saar Sommersemester 2024 Projekt Boerse in Verteilte Systeme


VM Abbilder Unter:  https://drive.google.com/drive/folders/12wTkE-EO18yDpoPQ4pQ5jUICU_-_fLEm?usp=sharing

*-- Struktur Erklärung --*

Models: Diese Dateien repräsentieren die Datenobjekte, die in der Datenbank und im Programm verwendet werden.

Services: Diese kümmern sich um die Logik und die Manipulation der Daten, die von den Models kommen und zu den Datenbanken geschickt werden.

Controllers: Die Controller interagieren direkt mit den Nutzern (CLI oder per API), sie rufen die Services auf und verarbeiten die Eingabe.

Utilities: Klassen wie der DatabaseManager, die die allgemeine Konfiguration und Verwaltung unterstützen.

Main: Das Hauptprogramm, welches alles steuert. 
