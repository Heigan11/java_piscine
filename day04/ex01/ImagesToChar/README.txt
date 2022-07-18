javac -d target/ src/java/edu/school21/printer/*/*.java
cp src/manifest.txt target/
cp -r src/resources target/
cd target/
jar -cvfm images-to-chars-printer.jar manifest.txt edu/school21/printer/*/*.class
rm manifest.txt
cd ..
java -jar target/images-to-chars-printer.jar . o
