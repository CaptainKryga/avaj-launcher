# avaj-launcher

### Project about code implementation based on uml table

![Image alt](https://github.com/CaptainKryga/school21-avaj_launcher/blob/main/git/avaj_uml.png)

The goal of the project is to write a program using the MVC pattern.
1. Parsing.
2. Registration of aircraft from the submitted file.
3. The weather station sends weather data to each aircraft in its coordinates and it reacts to it by changing its position in space (changing coordinates and throwing a phrase into a new file).
4. If the height is equal to or less than zero, we land the device and unsubscribe it from the weather station.
5. At the end of all iterations, the program creates a simulation.txt file in which all messages from the weather station and air facilities are stored according to the subject.

Subject: https://github.com/CaptainKryga/school21-avaj_launcher/blob/main/git/en.subject.pdf

For build and start:\
\
find * -name "*.java" > sources.txt\
javac @sources.txt\
java Simulator/Simulator tests/default_subj\
\
sample argument file for project operation:\
25\
Fly.Baloon B1 2 3 20\
Fly.Baloon B2 1 8 66\
Fly.JetPlane J1 23 44 32\
Fly.Helicopter H1 654 33 20\
Fly.Helicopter H2 22 33 44\
Fly.Helicopter H3 98 68 99\
Fly.Baloon B3 102 22 34\
Fly.JetPlane J2 11 99 768\
Fly.Helicopter H4 223 23 54\
