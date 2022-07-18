jar xf lib/jcommander-1.82.jar
jar xf lib/JCDP-4.0.2.jar
rm -rf META-INF
mv com target/
javac -d target -classpath lib/jcommander-1.82.jar:lib/JCDP-4.0.2.jar src/java/edu/school21/printer/*/*.java
jar cfm target/images-to-chars-printer.jar  src/manifest.txt  -C target .
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
